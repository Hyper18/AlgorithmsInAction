using namespace std;
#include <iostream>

const int N = 110, INF = 1e9;
int w[N][N], f[N][N];
int n;

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%d", &w[i][j]);
			f[i][j] = INF;
		}
	}

	f[1][1] = w[1][1];
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == 1 && j == 1) {
				continue;
			}
			if (i > 1) {
				f[i][j] = min(f[i][j], f[i - 1][j] + w[i][j]);
			}
			if (j > 1) {
				f[i][j] = min(f[i][j], f[i][j - 1] + w[i][j]);
			}
		}
	}

	printf("%d", f[n][n]);
}