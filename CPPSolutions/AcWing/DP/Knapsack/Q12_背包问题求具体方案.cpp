using namespace std;
#include <iostream>

const int N = 1010;
int v[N], w[N];
int f[N][N];
int n, m;

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++) scanf("%d%d", &v[i], &w[i]);
	for (int i = n; i >= 1; i--) {
		for (int j = 0; j <= m; j++) {
			f[i][j] = f[i + 1][j];
			if (v[i] <= j) f[i][j] = max(f[i][j], f[i + 1][j - v[i]] + w[i]);
		}
	}
	int j = m;
	for (int i = 1; i <= n; i++) {
		if (j >= v[i] && f[i][j] == f[i + 1][j - v[i]] + w[i]) {
			printf("%d ", i);
			j -= v[i];
		}
	}
}