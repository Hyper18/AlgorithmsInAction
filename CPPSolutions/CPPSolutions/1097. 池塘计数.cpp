using namespace std;
#include <iostream>
#include <cstring>
#include <queue>
#define x first
#define y second

const int N = 1010;

typedef pair<int, int> PII;

int n, m;
char g[N][N];
bool vis[N][N];

void bfs(int sx, int sy) {
	queue<PII> q;
	q.push({ sx, sy });
	vis[sx][sy] = true;
	while (!q.empty()) {
		auto p = q.front();
		q.pop();
		for (int i = p.x - 1; i <= p.x + 1; i++) {
			for (int j = p.y - 1; j <= p.y + 1; j++) {
				if ((i == p.x && j == p.y) || i < 0 || i >= n || j < 0 || j >= m || g[i][j] == '.' || vis[i][j]) continue;
				vis[i][j] = true;
				q.push({ i, j });
			} 
		}
	}
}

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%s", g[i]);
	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (vis[i][j]) continue;
			if (g[i][j] == 'W') {
				bfs(i, j);
				ans++;
			}
		}
	}
	printf("%d", ans);
}