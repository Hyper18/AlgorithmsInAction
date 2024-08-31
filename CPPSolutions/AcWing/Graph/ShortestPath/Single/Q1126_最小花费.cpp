using namespace std;

#include <iostream>
#include <cstring>
#include <queue>

const int N = 2010, M = 1e5 * 2 + 10;

int n, m, st, ed;
int h[N], e[M], ne[M], idx;
double d[N], w[M];
bool vis[N];

void addEdge(int a, int b, double c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void spfa(int ed) {
    d[ed] = 1;

    queue<int> q;
    q.push(ed);
    vis[ed] = true;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        vis[u] = false;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (d[j] < d[u] * w[i]) {
                d[j] = d[u] * w[i];
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
        double dis = 1 - ((c * 1.0) / 100.0);
        addEdge(a, b, dis), addEdge(b, a, dis);
    }
    scanf("%d%d", &st, &ed);
    spfa(ed);
    printf("%.8lf", 100.0 / d[st]);
}