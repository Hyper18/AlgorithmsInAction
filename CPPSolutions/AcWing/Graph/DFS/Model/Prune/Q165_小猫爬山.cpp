using namespace std;

#include <iostream>
#include <algorithm>

const int N = 20;

int n, m, ans = N;
int w[N], sum[N];

void dfs(int u, int k) {
    if (k >= ans) return;
    if (u == n) ans = k;
    for (int i = 0; i < k; i++) {
        if (sum[i] + w[u] <= m) {
            sum[i] += w[u];
            dfs(u + 1, k);
            sum[i] -= w[u];
        }
    }
    sum[k] = w[u];
    dfs(u + 1, k + 1);
    sum[k] = 0;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++) scanf("%d", &w[i]);
    sort(w, w + n), reverse(w, w + n);
    dfs(0, 0);
    printf("%d", ans);
}