using namespace std;
#include <iostream>

const int N = 3e4 + 10;
int f[N];
int m, n;

int main() {
	scanf("%d%d", &m, &n);
	for (int i = 0; i < n; i++) {
		int v, w;
		scanf("%d%d", &v, &w);
		for (int j = m; j >= v; j--) f[j] = max(f[j], f[j - v] + v * w);
	}
	printf("%d", f[m]);
}