using namespace std;
#include <iostream>
#include <cstring>
#include <queue>

#define x first
#define y second

const int N = 23;
const int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };

typedef pair<int, int> PII;

int n, m;
char g[N][N];
bool vis[N][N];

int bfs(int sx, int sy) {
	queue<PII> q;
	q.push({ sx, sy });
	vis[sx][sy] = true;
	int ans = 0;
	while (!q.empty()) {
		auto p = q.front();
		q.pop();
		ans++;
		for (int i = 0; i < 4; i++) {
			int nx = p.x + dx[i], ny = p.y + dy[i];
			if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == '#') continue;
			vis[nx][ny] = true;
			q.push({ nx, ny });
		}
	}

	return ans;
}

int main() {
	while (true) {
		scanf("%d%d", &n, &m);
		if (n == 0 && m == 0) break;
		int sx = 0, sy = 0;
		for (int i = 0; i < m; i++) {
			scanf("%s", g[i]);
			for (int j = 0; j < n; j++)
				if (g[i][j] == '@')
					sx = i, sy = j;
		}
		memset(vis, 0, sizeof vis);
		printf("%d\n", bfs(sx, sy));
	}
}