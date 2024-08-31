using namespace std;

#include <iostream>

const int N = 1e3 + 10;
char a[N], b[N];
int f[N][N];
int n, m;

int main() {
    scanf("%d%s%d%s", &n, a + 1, &m, b + 1);
    for (int i = 0; i <= n; i++) {
        f[i][0] = i;
    }
    for (int j = 0; j <= m; j++) {
        f[0][j] = j;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            f[i][j] = a[i] == b[j] ? f[i - 1][j - 1] : min(min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
        }
    }

    printf("%d", f[n][m]);
}