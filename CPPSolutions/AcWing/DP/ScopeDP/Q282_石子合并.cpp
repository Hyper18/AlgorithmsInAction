using namespace std;

#include <iostream>

const int N = 310;
const int INF = 1e9;

int n;
int a[N];
int f[N][N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &a[i]);
        a[i] += a[i - 1];
    }

    for (int len = 2; len <= n; len++) {
        for (int i = 1; i + len - 1 <= n; i++) {
            int l = i, r = i + len - 1;
            f[l][r] = INF;
            for (int k = l; k < r; k++) {
                f[l][r] = min(f[l][r], f[l][k] + f[k + 1][r] + a[r] - a[l - 1]);
            }
        }
    }

    printf("%d", f[1][n]);
}