using namespace std;
#include <iostream>

const int N = 110;
int v[N], w[N];
int f[N];
int n, m;

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++) {
		int s;
		scanf("%d", &s);
		for (int j = 1; j <= s; j++) scanf("%d%d", &v[j], &w[j]);
		for (int j = m; j >= 0; j--) for (int k = 1; k <= s; k++) if (v[k] <= j) f[j] = max(f[j], f[j - v[k]] + w[k]);
	}
	printf("%d", f[m]);
}