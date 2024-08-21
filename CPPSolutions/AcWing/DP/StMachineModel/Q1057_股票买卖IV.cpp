using namespace std;
#include <iostream>

const int N = 1e5 + 10, M = 105, INF = 10e6;
int w[N];
int f[N][M][2];
int n, m;

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++) scanf("%d", &w[i]);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            f[i][j][0] = j == 0 ? 0 : -INF;
            f[i][j][1] = -INF;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            f[i][j][0] = max(f[i - 1][j][0], f[i - 1][j][1] + w[i]);
            f[i][j][1] = max(f[i - 1][j][1], f[i - 1][j - 1][0] - w[i]);
        }
    }

    int ans = 0;
    for (int i = 1; i <= m; i++) {
        ans = max(ans, f[n][i][0]);
    }
    printf("%d\n", ans);
}