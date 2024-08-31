using namespace std;

#include <iostream>
#include <queue>

#define x first
#define y second

const int N = 55;
const int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};

typedef pair<int, int> PII;

int n, m;
int g[N][N];
bool vis[N][N];

int bfs(int sx, int sy) {
    queue <PII> q;
    q.push({sx, sy});
    vis[sx][sy] = true;
    int ans = 0;
    while (!q.empty()) {
        auto p = q.front();
        q.pop();
        ans++;
        for (int i = 0; i < 4; i++) {
            int x = p.x + dx[i], y = p.y + dy[i];
            if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] || g[p.x][p.y] >> i & 1) continue;
            vis[x][y] = true;
            q.push({x, y});
        }
    }
    return ans;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) scanf("%d", &g[i][j]);
    int cnt = 0, ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (vis[i][j]) continue;
            ans = max(ans, bfs(i, j));
            cnt++;
        }
    }
    printf("%d\n%d", cnt, ans);
}