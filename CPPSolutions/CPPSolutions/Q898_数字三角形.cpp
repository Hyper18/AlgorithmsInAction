using namespace std;
#include <iostream>

const int N = 5e2 + 10;
const int INF = 1e9;
int a[N][N], f[N][N];
int n;

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			scanf("%d", &a[i][j]);
		}
	}

	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= i + 1; j++) {
			f[i][j] = -INF;
		}
	}

	f[1][1] = a[1][1];
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			f[i][j] = max(f[i - 1][j - 1], f[i - 1][j]) + a[i][j];
		}
	}

	int res = -INF;
	for (int i = 1; i <= n; i++) {
		res = max(res, f[n][i]);
	}

	printf("%d", res);
}