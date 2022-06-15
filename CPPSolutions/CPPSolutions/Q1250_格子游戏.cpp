using namespace std;
#include <iostream>

const int N = 40010;

int n, m;
int p[N];

int get(int x, int y) {
	return x * n + y;
}

int find(int x) {
	if (p[x] != x) p[x] = find(p[x]);
	return p[x];
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n * n; i++) p[i] = i;

	int ans = 0;
	for (int i = 1; i <= m; i++) {
		int x, y;
		char d;
		cin >> x >> y >> d;
		x -= 1, y -= 1; // ������Ҫ��Ӧ�������±�λ��

		int a = get(x, y);
		int b = d == 'D' ? get(x + 1, y) : get(x, y + 1);

		int pa = find(a), pb = find(b);
		if (pa == pb) {
			ans = i; // Χ���˷�յ�Ȧ
			break;
		}
		p[pa] = pb;
	}
	if (!ans) cout << "draw";
	else cout << ans;
}