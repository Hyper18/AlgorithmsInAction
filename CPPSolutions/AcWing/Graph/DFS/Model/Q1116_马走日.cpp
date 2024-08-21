using namespace std;
#include <iostream>
#include <cstring>

const int N = 10;
const int dx[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
const int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

int t, n, m, ans;
bool g[N][N];

void dfs(int sx, int sy, int step) {
	if (step == n * m) {
		ans++;
		return;
	}
	g[sx][sy] = true;
	for (int i = 0; i < 8; i++) {
		int x = sx + dx[i], y = sy + dy[i];
		if (x < 0 || x >= n || y < 0 || y >= m || g[x][y]) continue;
		dfs(x, y, step + 1);
	}
	g[sx][sy] = false;
}

int main() {
	scanf("%d", &t);
	while (t--) {
		int sx, sy;
		scanf("%d%d%d%d", &n, &m, &sx, &sy);
		
		ans = 0;
		// 由于回溯重置了访问状态，实际也可以不每次重新初始化（快80ms左右，与t有关）
		memset(g, 0, sizeof g); 
		dfs(sx, sy, 1);
		printf("%d\n", ans);
	}
}