using namespace std;

#include <iostream>

const int N = 3010;
int a[N], b[N], f[N][N];
int n;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    for (int i = 1; i <= n; i++) scanf("%d", &b[i]);

    for (int i = 1; i <= n; i++) {
        int preMax = 1;
        for (int j = 1; j <= n; j++) {
            f[i][j] = f[i - 1][j];
            if (a[i] == b[j]) f[i][j] = max(f[i][j], preMax);
            if (a[i] > b[j]) preMax = max(preMax, f[i - 1][j] + 1);
        }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) ans = max(ans, f[n][i]);

    printf("%d", ans);
}