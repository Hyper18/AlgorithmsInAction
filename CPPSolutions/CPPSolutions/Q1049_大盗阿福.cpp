using namespace std;
#include <iostream>

const int N = 1e5 + 10;
int f[N][2];
int t, n, w;

int main() {
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		for (int i = 1; i <= n; i++) {
			scanf("%d", &w);
			f[i][0] = max(f[i - 1][0], f[i - 1][1]);
			f[i][1] = f[i - 1][0] + w;
		}
		printf("%d\n", max(f[n][0], f[n][1]));
	}
}