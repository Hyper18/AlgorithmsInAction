using namespace std;
#include <iostream>
#include <queue>

#define x first
#define y second 

const int N = 1010;

typedef pair<int, int> PII;

int n;
bool hasHigher, hasLower;
int g[N][N];
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
				if ((i == p.x && j == p.y) || i < 0 || i >= n || j < 0 || j >= n) continue;
				if (g[i][j] != g[p.x][p.y]) {
					if (g[i][j] > g[p.x][p.y]) hasHigher = true;
					else hasLower = true;
				}
				else if (!vis[i][j]) {
					vis[i][j] = true;
					q.push({ i, j });
				}
			}
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) scanf("%d", &g[i][j]);
	int mount = 0, valley = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (vis[i][j]) continue;
			hasHigher = false, hasLower = false;
			bfs(i, j);
			if (!hasHigher) mount++;
			if (!hasLower) valley++;
		}
	}
	printf("%d %d", mount, valley);
}