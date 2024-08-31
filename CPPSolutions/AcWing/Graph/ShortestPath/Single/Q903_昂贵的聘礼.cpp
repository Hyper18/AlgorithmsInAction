using namespace std;

#include <iostream>
#include <cstring>
#include <queue>

const int N = 110, M = 1e4 + 10, INF = 0x3f3f3f3f;

int m, n;
int h[N], e[M], ne[M], w[M], idx;
int d[N], level[N];
bool vis[N];

void addEdge(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void spfa(int l, int r) {
    memset(d, INF, sizeof d);
    d[0] = 0;
    queue<int> q;
    q.push(0);
    vis[0] = true;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        vis[u] = false;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (l <= level[j] && level[j] <= r && d[j] > d[u] + w[i]) {
                d[j] = d[u] + w[i];
                if (vis[j]) continue;
                vis[j] = true;
                q.push(j);
            }
        }
    }
}

int main() {
    scanf("%d%d", &m, &n);
    memset(h, -1, sizeof h);
    for (int i = 1; i <= n; i++) {
        int price, cnt;
        scanf("%d%d%d", &price, &level[i], &cnt);
        addEdge(0, i, price);
        while (cnt--) {
            int j, value;
            scanf("%d%d", &j, &value);
            addEdge(j, i, value);
        }
    }
    int ans = INF;
    for (int i = level[1] - m; i <= level[1]; i++) {
        spfa(i, i + m);
        ans = min(ans, d[1]);
    }
    printf("%d", ans);
}