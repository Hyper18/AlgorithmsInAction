using namespace std;

#include <iostream>
#include <cstring>

const int N = 1e4 + 10, M = N * 2, INF = 0x3f3f3f3f;

int n, idx;
int h[N], e[M], ne[M], w[M];
int d1[N], d2[N], parents[N], up[N];
bool isLeaf[N];

void addEdge(int a, int b, int c) {
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
}

int dfsDown(int u, int par) {
    d1[u] = d2[u] = -INF;
    for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (j == par) continue;

        int d = dfsDown(j, u) + w[i];
        if (d >= d1[u]) {
            d2[u] = d1[u];
            d1[u] = d;
            parents[u] = j;
        } else if (d > d2[u]) d2[u] = d;
    }

    if (d1[u] == -INF) {
        d1[u] = d2[u] = 0;
        isLeaf[u] = true;
    }

    return d1[u];
}

void dfsUp(int u, int par) {
    for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (j == par) continue;

        if (parents[u] == j) up[j] = max(up[u], d2[u]) + w[i];
        else up[j] = max(up[u], d1[u]) + w[i];

        dfsUp(j, u);
    }
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof h);
    for (int i = 0; i < n - 1; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        addEdge(a, b, c);
        addEdge(b, a, c);
    }
    dfsDown(1, -1);
    dfsUp(1, -1);

    int ans = d1[1];
    for (int i = 2; i <= n; i++)
        ans = isLeaf[i] ? min(ans, up[i]) : min(ans, max(d1[i], up[i]));
    printf("%d", ans);
}