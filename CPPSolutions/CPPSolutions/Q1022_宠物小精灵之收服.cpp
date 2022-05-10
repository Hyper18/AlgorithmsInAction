using namespace std;
#include <iostream>

const int N = 1e3 + 10, M = 510;
int f[N][M];
int m1, m2, n;

int main() {
	scanf("%d%d%d", &m1, &m2, &n);
	for (int i = 1; i <= n; i++) {
		int v1, v2;
		scanf("%d%d", &v1, &v2);
		for (int j = m1; j >= v1; j--) {
			for (int k = m2 - 1; k >= v2; k--) {
				f[j][k] = max(f[j][k], f[j - v1][k - v2] + 1);
			}
		}
	}
	int r = m2 - 1;
	while (r > 0 && f[m1][m2 - 1] == f[m1][r - 1]) r--;

	printf("%d %d", f[m1][m2 - 1], m2 - r);
}