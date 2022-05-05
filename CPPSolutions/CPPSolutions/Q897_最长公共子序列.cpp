using namespace std;
#include <iostream>

const int N = 1e3 + 10;
char a[N], b[N];
int f[N][N];
int n, m;

int main() {
	scanf("%d%d%s%s", &n, &m, a + 1, b + 1); // ע�������д�����������λ�Σ�����������ַ��ʼ������Ӧд&����ֱ��ָ���˵�ַ��

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			f[i][j] = a[i] == b[j] ? f[i - 1][j - 1] + 1 : max(f[i - 1][j], f[i][j - 1]);

	printf("%d", f[n][m]);
}