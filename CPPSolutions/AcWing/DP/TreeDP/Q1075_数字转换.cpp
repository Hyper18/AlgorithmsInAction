using namespace std;

#include <iostream>
#include <cstring>

const int N = 5e4 + 10, M = N;

int n, idx, ans;
int h[N], e[M], ne[M], sum[M];
bool vis[N];

void addEdge(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}

int dfs(int u) {
    vis[u] = true;

    int dis = 0, d1 = 0, d2 = 0;
    for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (vis[j]) continue;

        int d = dfs(j);
        dis = max(dis, d);
        if (d >= d1) {
            d2 = d1;
            d1 = d;
        } else if (d > d2) d2 = d;
    }
    ans = max(ans, d1 + d2);

    return dis + 1;
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        for (int j = 2; j <= n / i; j++)
            sum[i * j] += i;
    memset(h, -1, sizeof h);
    for (int i = 2; i <= n; i++) {
        if (sum[i] < i)
            addEdge(sum[i], i);
    }

    for (int i = 1; i <= n; i++)
        dfs(i);

    printf("%d", ans);
}