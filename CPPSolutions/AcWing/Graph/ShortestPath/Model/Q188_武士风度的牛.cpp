using namespace std;

#include <iostream>
#include <queue>

#define x first
#define y second

const int N = 155;
const int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
const int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

typedef pair<int, int> PII;

int n, m;
char g[N][N];
int d[N][N];
bool vis[N][N];

int bfs(int sx, int sy) {
    queue <PII> q;
    q.push({sx, sy});
    vis[sx][sy] = true;
    while (!q.empty()) {
        auto p = q.front();
        q.pop();
        for (int i = 0; i < 8; i++) {
            int x = p.x + dx[i], y = p.y + dy[i];
            if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || g[x][y] == '*') continue;
            if (g[x][y] == 'H') return d[p.x][p.y] + 1;
            vis[x][y] = true;
            q.push({x, y});
            d[x][y] = d[p.x][p.y] + 1;
        }
    }

    return -1;
}

int main() {
    scanf("%d%d", &n, &m);
    int sx = 0, sy = 0;
    for (int i = 0; i < m; i++) {
        scanf("%s", g[i]);
        for (int j = 0; j < n; j++) {
            if (g[i][j] == 'K') {
                sx = i;
                sy = j;
            }
        }
    }
    printf("%d", bfs(sx, sy));
}