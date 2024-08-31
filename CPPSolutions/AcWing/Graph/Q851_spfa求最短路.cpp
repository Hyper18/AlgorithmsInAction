using namespace std;

#include <iostream>
#include <cstring>
#include <queue>

const int N = 1e5 + 10, INF = 0x3f3f3f3f;

int n, m;
int h[N], e[N], ne[N], w[N], idx;
int d[N];
bool vis[N];

void addEdge(int a, int b, int c) {
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
}

int spfa() {
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
                q.push(j);
                vis[j] = true;
            }
        }
    }

    return d[n];
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        addEdge(a, b, c);
    }
    int ans = spfa();
    if (ans == INF) printf("impossible");
    else printf("%d", ans);
}