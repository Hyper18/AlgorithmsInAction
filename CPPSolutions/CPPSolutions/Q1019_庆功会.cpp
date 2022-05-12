using namespace std;
#include <iostream>

const int N = 6e3 + 10;

int f[N];
int n, m;

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) {
		int v, w, s;
		scanf("%d%d%d", &v, &w, &s);
		for (int j = m; j >= v; j--) for (int k = 1; k <= s && k * v <= j; k++) f[j] = max(f[j], f[j - k * v] + k * w);
	}
	printf("%d", f[m]);
}