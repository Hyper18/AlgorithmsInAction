using namespace std;

#include <iostream>
#include <queue>

typedef pair<int, int> PII;

const int N = 110;
const int dirs[4][2] = {{1,  0},
                        {0,  1},
                        {-1, 0},
                        {0,  -1}};

int n, m;
int g[N][N], d[N][N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
            scanf("%d", &g[i][j]);
    queue <PII> q;
    d[1][1] = 0;
    q.push({1, 1});
    while (!q.empty()) {
        auto pos = q.front();
        q.pop();
        for (auto &dir: dirs) {
            int x = pos.first + dir[0], y = pos.second + dir[1];
            if (x < 1 || x > n || y < 1 || y > m || g[x][y] == 1 || d[x][y] != 0) continue;
            d[x][y] = d[pos.first][pos.second] + 1;
            q.push({x, y});
        }
    }
    printf("%d", d[n][m]);
}