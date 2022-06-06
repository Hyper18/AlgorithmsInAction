using namespace std;
#include <iostream>
#include <cstring>

const int N = 510;
const int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };

int k, n, x, y, ex, ey;
char g[N][N];
bool vis[N][N];

bool dfs(int x, int y) {
	if (g[x][y] == '#') return false;
	if (x == ex && y == ey) return true;
	vis[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i], ny = y + dy[i];
		if (nx < 0 || nx >= n || ny < 0 || ny >= n || vis[nx][ny]) continue;
		if (dfs(nx, ny)) return true;
	}

	return false;
}

int main() {
	scanf("%d", &k);
	while (k--) {
		scanf("%d", &n);
		for (int i = 0; i < n; i++)
			scanf("%s", g[i]);
		memset(vis, false, sizeof vis);
		scanf("%d%d%d%d", &x, &y, &ex, &ey);
		printf(dfs(x, y) ? "YES\n" : "NO\n");
	}
}