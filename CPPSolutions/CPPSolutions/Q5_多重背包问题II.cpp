using namespace std;
#include <iostream>

// �����ر���������Ϊ01�������⣬���ö������Ż��������ɲ��Ϊ1000 * log2(2000)����Ʒ��ע�⣺����log��2Ϊ�ף�
const int N = 11000 + 10, M = 2e3 + 10;
int v[N], w[N], f[N];
int n, m;

int main() {
	scanf("%d %d", &n, &m);

	int cnt = 0;
	for (int i = 1; i <= n; i++) {
		int a, b, s;
		scanf("%d %d %d", &a, &b, &s);
		int k = 1;
		while (k <= s) {
			cnt++;
			v[cnt] = a * k;
			w[cnt] = b * k;
			s -= k;
			k <<= 1;
		}
		if (s > 0) {
			cnt++;
			v[cnt] = a * s;
			w[cnt] = b * s;
		}
	}

	n = cnt;
	for (int i = 1; i <= n; i++) {
		for (int j = m; j >= v[i]; j--) {
			f[j] = max(f[j], f[j - v[i]] + w[i]);
		}
	}

	printf("%d", f[m]);
}