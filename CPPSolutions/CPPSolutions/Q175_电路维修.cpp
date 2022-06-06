using namespace std;
#include <iostream>
#include <cstring>
#include <deque>

#define x first
#define y second

const int N = 510, INF = 0x3f3f3f3f;
const int dx[] = { -1, -1, 1, 1 }, dy[] = { -1, 1, 1, -1 };
const int ix[] = { -1, -1, 0, 0 }, iy[] = { -1, 0, 0, -1 };
const char cs[] = "\\/\\/";

typedef pair<int, int> PII;

int t, n, m;
char g[N][N];
int d[N][N];
bool vis[N][N];

int bfs() {
	memset(d, INF, sizeof d);
	memset(vis, false, sizeof vis);
	d[0][0] = 0;
	deque<PII> q;
	q.push_back({ 0, 0 });
	while (!q.empty()) {
		auto p = q.front();
		q.pop_front();
		if (vis[p.x][p.y]) continue;
		vis[p.x][p.y] = true;

		for (int i = 0; i < 4; i++) {
			int x = p.x + dx[i], y = p.y + dy[i];
			if (x < 0 || x > n || y < 0 || y > m) continue;

			int cx = p.x + ix[i], cy = p.y + iy[i];
			int dis = d[p.x][p.y] + (g[cx][cy] != cs[i]);

			if (d[x][y] > dis) {
				d[x][y] = dis;
				if (g[cx][cy] != cs[i]) q.push_back({ x, y });
				else q.push_front({ x, y });
			}
		}
	}

	return d[n][m];
}

int main() {
	scanf("%d", &t);
	while (t--) {
		scanf("%d%d", &n, &m);
		for (int i = 0; i < n; i++) 
			scanf("%s", g[i]);
		int ans = bfs();
		if (ans == INF) puts("NO SOLUTION");
		else printf("%d\n", ans);
	}
}