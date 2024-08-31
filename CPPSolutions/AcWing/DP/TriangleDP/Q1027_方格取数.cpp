using namespace std;

#include <iostream>

const int N = 110;
int w[N][N], f[N * 2][N][N];
int n;

int main() {
    scanf("%d", &n);
    while (true) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        if (a == 0 && b == 0 && c == 0) {
            break;
        }
        w[a][b] = c;
    }

    for (int k = 2; k <= n * 2; k++) {
        for (int i1 = 1; i1 <= n; i1++) {
            for (int i2 = 1; i2 <= n; i2++) {
                int j1 = k - i1, j2 = k - i2;
                if (j1 < 0 || j1 > n || j2 < 0 || j2 > n) {
                    continue;
                }
                int t = w[i1][j1];
                if (i1 != i2) t += w[i2][j2];

                int &x = f[k][i1][i2];
                x = max(x, max(
                        max(f[k - 1][i1 - 1][i2], f[k - 1][i1][i2 - 1]),
                        max(f[k - 1][i1 - 1][i2 - 1], f[k - 1][i1][i2])
                ) + t);
            }
        }
    }

    printf("%d", f[n * 2][n][n]);
}