using namespace std;

#include <iostream>
#include <cstring>
#include <queue>

const int N = 110, INF = 0x3f3f3f3f;

int m, n;
int w[N][N], d[N], level[N];
bool vis[N];

int dijkstra(int l, int r) {
    memset(d, INF, sizeof d);
    memset(vis, false, sizeof vis);
    d[0] = 0;
    for (int i = 1; i <= n + 1; i++) {
        int t = -1;
        for (int j = 0; j <= n; j++) {
            if (vis[j]) continue;
            if (t == -1 || d[t] > d[j])
                t = j;
        }
        vis[t] = true;
        for (int j = 1; j <= n; j++)
            if (l <= level[j] && level[j] <= r)
                d[j] = min(d[j], d[t] + w[t][j]);
    }

    return d[1];
}

int main() {
    scanf("%d%d", &m, &n);
    memset(w, INF, sizeof w);
    for (int i = 1; i <= n; i++) w[i][i] = 0;
    for (int i = 1; i <= n; i++) {
        int price, cnt;
        scanf("%d%d%d", &price, &level[i], &cnt);
        w[0][i] = min(w[0][i], price);
        while (cnt--) {
            int j, value;
            scanf("%d%d", &j, &value);
            w[j][i] = min(w[j][i], value);
        }
    }
    int ans = INF;
    for (int i = level[1] - m; i <= level[1]; i++)
        ans = min(ans, dijkstra(i, i + m));
    printf("%d", ans);
}