using namespace std;

#include <iostream>
#include <cstring>

const int N = 1e4 + 10, INF = 1e9;
int f[N], g[N];
int n, m;

int main() {
    scanf("%d%d", &n, &m);

    memset(f, -INF, sizeof f);
    f[0] = 0;
    g[0] = 1;
    for (int i = 0; i < n; i++) {
        int v;
        scanf("%d", &v);
        for (int j = m; j >= v; j--) {
            int maxV = max(f[j], f[j - v] + v);
            int cnt = 0;
            if (maxV == f[j]) cnt += g[j];
            if (maxV == f[j - v] + v) cnt += g[j - v];
            g[j] = cnt;
            f[j] = maxV;
        }
    }

    int maxV = -INF, ans = 0;
    for (int i = 0; i <= m; i++) maxV = max(maxV, f[i]);
    for (int i = 0; i <= m; i++) if (maxV == f[i]) ans += g[i];
    printf("%d", ans);
}