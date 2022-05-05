using namespace std;
#include <iostream>

const int N = 1e3 + 10;
char a[N], b[N];
int f[N][N];
int n, m;

int main() {
	scanf("%d%d%s%s", &n, &m, a + 1, b + 1); // 注意这里的写法，如果对齐位次（不从数组首址开始），则不应写&符（直接指定了地址）

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			f[i][j] = a[i] == b[j] ? f[i - 1][j - 1] + 1 : max(f[i - 1][j], f[i][j - 1]);

	printf("%d", f[n][m]);
}