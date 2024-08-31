using namespace std;

#include <iostream>
#include <cstring>
#include <queue>

const int N = 110, M = 200 * 2 + 10, INF = 0x3f3f3f3f;

int n, m;
int h[N], e[M], ne[M], w[M], idx;
int d[N];
bool vis[N];

void addEdge(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void spfa() {
    memset(d, INF, sizeof d);
    d[1] = 0;

    queue<int> q;
    q.push(1);
    vis[1] = true;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        vis[u] = false;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (d[j] > d[u] + w[i]) {
                d[j] = d[u] + w[i];
                if (vis[j]) continue;
                vis[j] = true;
                q.push(j);
            }
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        addEdge(a, b, c), addEdge(b, a, c);
    }
    spfa();
    int ans = 0;
    for (int i = 1; i <= n; i++) ans = max(ans, d[i]);
    if (ans == INF) printf("-1");
    else printf("%d", ans);
}