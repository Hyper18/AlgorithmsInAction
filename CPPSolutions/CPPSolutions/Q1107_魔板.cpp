using namespace std;
#include <iostream>
#include <algorithm>
#include <cstring>
#include <unordered_map>
#include <queue>

char g[2][4]; // ���ħ��״̬
unordered_map<string, pair<char, string>> op;
unordered_map<string, int> d;

// ���ַ������õ�ǰ�����״̬
void set(string state) {
	for (int i = 0; i < 4; i++)
		g[0][i] = state[i];
	for (int i = 7, j = 0; j < 4; i--, j++)
		g[1][j] = state[i];
}

// �����ǰ����������ַ�����
string get() {
	string ans;
	for (int i = 0; i < 4; i++)
		ans += g[0][i];
	for (int i = 3; i >= 0; i--)
		ans += g[1][i];
	return ans;
}

// ����һ��������������
string move0(string state) {
	set(state);
	for (int i = 0; i < 4; i++)
		swap(g[0][i], g[1][i]);
	return get();
}

// �������������Ҳ��в��뵽�����
string move1(string state) {
	set(state);
	char v0 = g[0][3], v1 = g[1][3]; // �ֶ�swap���������һ�е�������
	for (int i = 3; i > 0; i--) {
		g[0][i] = g[0][i - 1];
		g[1][i] = g[1][i - 1];
	}
	g[0][0] = v0, g[1][0] = v1; // ����
	return get();
}

// ���������������4������˳ʱ����ת
string move2(string state) {
	set(state);
	char v = g[0][1]; // ͬ��
	g[0][1] = g[1][1]; // ����ת
	g[1][1] = g[1][2]; // ����ת
	g[1][2] = g[0][2]; // ����ת
	g[0][2] = v;	   // ����ת
	return get();
}

int bfs(string st, string ed) {
	if (st == ed) return 0;

	queue<string> q;
	q.push(st);
	d[st] = 0;
	while (!q.empty()) {
		auto p = q.front();
		q.pop();

		string m[3];
		m[0] = move0(p);
		m[1] = move1(p);
		m[2] = move2(p);

		for (int i = 0; i < 3; i++) {
			if (d.count(m[i])) continue;
			d[m[i]] = d[p] + 1;
			op[m[i]] = { 'A' + i, p };
			q.push(m[i]);
			if (m[i] == ed) return d[ed];
		}
	}

	return -1;
}

int main() {
	int x;
	string st = "12345678", ed;
	for (int i = 0; i < 8; i++) {
		scanf("%d", &x);
		ed += char(x + '0');
	}
	int step = bfs(st, ed);
	printf("%d\n", step);
	string ans;
	while (ed != st) {
		ans += op[ed].first;
		ed = op[ed].second;
	}
	reverse(ans.begin(), ans.end());
	if (step > 0) printf("%s", ans.c_str()); // %sĬ��ֻ�������char*
}