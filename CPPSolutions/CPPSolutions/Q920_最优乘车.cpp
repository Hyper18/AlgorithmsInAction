using namespace std;
#include <iostream>
#include <sstream>
#include <cstring>
#include <queue>

const int N = 510, INF = 0x3f3f3f3f;

int n, m;
bool g[N][N];
int st[N], d[N];

void bfs() {
	memset(d, INF, sizeof d);
	d[1] = 0;
	queue<int> q;
	q.push(1);
	while (!q.empty()) {
		int u = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (!g[u][i]) continue;
			if (d[i] > d[u] + 1) {
				d[i] = d[u] + 1;
				q.push(i);
			}
		}
	}
}

int main() {
	scanf("%d%d", &m, &n);
	string line;
	getline(cin, line); // 过滤第一行末回车
	while (m--) {
		getline(cin, line);
		stringstream ssin(line);
		int len = 0, s;
		while (ssin >> s) st[len++] = s;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++)
				g[st[i]][st[j]] = true;
	}
	bfs();
	if (d[n] == INF) printf("NO");
	else printf("%d", d[n] - 1);
}