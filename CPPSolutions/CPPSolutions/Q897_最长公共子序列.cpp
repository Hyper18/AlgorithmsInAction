using namespace std;
#include <iostream>

const int N = 1e3 + 10;
char a[N], b[N];
int f[N][N];
int n, m;

int main() {
	scanf("%d%d%s%s", &n, &m, &a, &b);

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			f[i][j] = a[i - 1] == b[j - 1] ? f[i - 1][j - 1] + 1 : max(f[i - 1][j], f[i][j - 1]);

	int ans = 0;
	for (int i = 1; i <= m; i++) {
		ans = max(ans, f[n][i]);
	}

	printf("%d", ans);
}