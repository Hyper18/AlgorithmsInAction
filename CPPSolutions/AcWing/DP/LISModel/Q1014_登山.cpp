using namespace std;

#include <iostream>

const int N = 1e3 + 10;
int h[N], f[N], g[N];
int n;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &h[i]);

    for (int i = 1; i <= n; i++) {
        f[i] = 1;
        for (int j = 1; j < i; j++) if (h[i] > h[j]) f[i] = max(f[i], f[j] + 1);
    }
    for (int i = n; i >= 1; i--) {
        g[i] = 1;
        for (int j = n; j > i; j--) if (h[i] > h[j]) g[i] = max(g[i], g[j] + 1);
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
        ans = max(ans, f[i] + g[i] - 1);
    }

    printf("%d", ans);
}