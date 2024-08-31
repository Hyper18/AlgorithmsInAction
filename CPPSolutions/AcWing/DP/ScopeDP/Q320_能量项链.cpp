using namespace std;

#include <iostream>

const int N = 205;

int a[N];
int f[N][N];

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        a[i + n] = a[i];
    }

    for (int len = 3; len <= n + 1; len++) {
        for (int l = 1; l + len - 1 <= n * 2; l++) {
            int r = l + len - 1;
            for (int k = l + 1; k < r; k++) {
                f[l][r] = max(f[l][r], f[l][k] + f[k][r] + a[l] * a[k] * a[r]);
            }
        }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) ans = max(ans, f[i][i + n]);
    printf("%d", ans);
}