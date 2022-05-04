using namespace std;
#include <iostream>

const int N = 1e3 + 10;
int n, m;
int v[N], w[N];
int f[N];

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		scanf("%d %d", &v[i], &w[i]);
	}
	for (int i = 1; i <= n; i++) {
		for (int j = v[i]; j <= m; j++) {
			f[j] = max(f[j], f[j - v[i]] + w[i]);
		}
	}

	printf("%d", f[m]);
}