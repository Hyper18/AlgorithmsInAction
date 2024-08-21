using namespace std;
#include <iostream>
#include <queue>
#include <cstring>

#define x first
#define y second

const int N = 1010;
const int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };

typedef pair<int, int> PII;

int n, m;
char g[N][N];
int d[N][N];

void bfs() {
	queue<PII> q;
	memset(d, -1, sizeof d);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (g[i][j] == '1') {
				d[i][j] = 0;
				q.push({ i, j });
			}
		}
	}
	while (!q.empty()) {
		auto p = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int x = p.x + dx[i], y = p.y + dy[i];
			if (x < 0 || x >= n || y < 0 || y >= m || d[x][y] != -1) continue;
			q.push({ x, y });
			d[x][y] = d[p.x][p.y] + 1;
		}
	}
}

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%s", g[i]);
	bfs();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%d ", d[i][j]);
		}
		puts("");
	}
}