using namespace std;

#include <iostream>
#include <queue>

#define x first
#define y second

const int N = 1010;
const int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};

typedef pair<int, int> PII;

int n;
int g[N][N];
PII path[N][N];
bool vis[N][N];

void bfs(int sx, int sy) {
    queue <PII> q;
    q.push({sx, sy});
    vis[sx][sy] = true;
    while (!q.empty()) {
        auto p = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int x = p.x + dx[i], y = p.y + dy[i];
            if (x < 0 || x >= n || y < 0 || y >= n || vis[x][y] || g[x][y] == 1) continue;
            vis[x][y] = true;
            q.push({x, y});
            path[x][y] = p;
        }
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) scanf("%d", &g[i][j]);
    bfs(n - 1, n - 1);
    PII p = {0, 0};
    while (true) {
        int ex = p.x, ey = p.y;
        printf("%d %d\n", ex, ey);
        if (ex == n - 1 && ey == n - 1) break;
        p = path[ex][ey];
    }
}