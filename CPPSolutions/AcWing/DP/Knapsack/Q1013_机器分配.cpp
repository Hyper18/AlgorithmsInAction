using namespace std;
#include <iostream>

const int N = 13, M = 18;
int w[N][M], f[N][M], res[N];
int n, m;

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &w[i][j]);
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= m; j++) {
			for (int k = 0; k <= j; k++) {
				f[i][j] = max(f[i][j], f[i - 1][j - k] + w[i][k]);
			}
		}
	}
	printf("%d\n", f[n][m]);

	int j = m;
	for (int i = n; i; i--) {
		for (int k = 0; k <= j; k++) {
			if (f[i][j] == f[i - 1][j - k] + w[i][k]) {
				res[i] = k;
				j -= k;
				break;
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		printf("%d %d\n", i, res[i]);
	}
}