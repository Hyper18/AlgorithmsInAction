using namespace std;

#include <iostream>
#include <cstring>

const int N = 110, M = N * 2;

int idx, n, m;
int h[N], e[M], ne[M], w[M];
int f[N][N];

void addEdge(int a, int b, int c) {
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
}

void dfs(int u, int par) {
    for (int i = h[u]; i != -1; i = ne[i]) {
        if (par == e[i]) continue;
        dfs(e[i], u);
        for (int j = m; j > 0; j--) {
            for (int k = 0; k + 1 <= j; k++) {
                f[u][j] = max(f[u][j], f[u][j - k - 1] + f[e[i]][k] + w[i]);
            }
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);
    for (int i = 0; i < n - 1; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        addEdge(a, b, c);
        addEdge(b, a, c);
    }
    dfs(1, -1);
    printf("%d", f[1][m]);
}