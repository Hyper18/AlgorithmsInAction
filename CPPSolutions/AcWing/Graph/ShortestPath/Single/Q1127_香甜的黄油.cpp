using namespace std;

#include <iostream>
#include <cstring>
#include <queue>

const int N = 810, M = 1450 * 2 + 10, INF = 0x3f3f3f3f;

int n, p, m;
int h[N], e[M], ne[M], w[M], idx;
int id[N], d[N];
bool vis[N];

void addEdge(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

int spfa(int st) {
    memset(d, INF, sizeof d);
    d[st] = 0;

    queue<int> q;
    q.push(st);
    vis[st] = true;
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
    int ans = 0;
    for (int i = 0; i < n; i++) {
        int j = id[i];
        if (d[j] == INF) return INF;
        ans += d[j];
    }
    return ans;
}

int main() {
    scanf("%d%d%d", &n, &p, &m);
    for (int i = 0; i < n; i++) scanf("%d", &id[i]);
    memset(h, -1, sizeof h);
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        addEdge(a, b, c), addEdge(b, a, c);
    }
    int ans = INF;
    for (int i = 1; i <= p; i++) ans = min(ans, spfa(i));
    printf("%d", ans);
}