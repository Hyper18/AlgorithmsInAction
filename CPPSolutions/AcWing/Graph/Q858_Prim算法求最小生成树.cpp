using namespace std;

#include <iostream>
#include <cstring>

const int N = 510, INF = 0x3f3f3f3f;

int n, m;
int g[N][N], d[N];
bool vis[N];

int prim() {
    memset(d, INF, sizeof d);
    int ans = 0;
    for (int i = 0; i < n; i++) {
        int t = -1;
        for (int j = 1; j <= n; j++)
            if (!vis[j] && (t == -1 || d[t] > d[j]))
                t = j;
        if (i && d[t] == INF) return INF;
        if (i) ans += d[t];
        vis[t] = true;
        for (int j = 1; j <= n; j++)
            d[j] = min(d[j], g[t][j]);
    }

    return ans;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(g, INF, sizeof g);
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        g[a][b] = g[b][a] = min(g[a][b], c);
    }
    int ans = prim();
    if (ans == INF) printf("impossible");
    else printf("%d", ans);
}