using namespace std;

#include <iostream>
#include <cstring>

const int M = 24, N = 82, INF = 0x3f;
int f[M][N];

int main() {
    int m, n, K;
    scanf("%d%d%d", &m, &n, &K);

    memset(f, INF, sizeof f);
    f[0][0] = 0;
    for (int i = 0; i < K; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        for (int j = m; j >= 0; j--) {
            for (int k = n; k >= 0; k--) {
                f[j][k] = min(f[j][k], f[max(0, j - a)][max(0, k - b)] + c);
            }
        }
    }
    printf("%d", f[m][n]);
}