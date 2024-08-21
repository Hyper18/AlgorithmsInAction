using namespace std;
#include <iostream>
#include <cstring>

const int N = 23;
const int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };

int n, m;
char g[N][N];
bool vis[N][N];

int dfs(int x, int y) {
    int ans = 1;
    vis[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == '#') continue;
        ans += dfs(nx, ny);
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
        printf("%d\n", dfs(sx, sy));
    }
}