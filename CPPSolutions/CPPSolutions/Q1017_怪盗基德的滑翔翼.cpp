using namespace std;
#include <iostream>

const int N = 110;
int h[N], f[N];
int k, n;

int main() {
	scanf("%d", &k);
	while (k--) {
		scanf("%d", &n);
		for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			f[i] = 1;
			for (int j = 1; j < i; j++) if (h[i] < h[j]) f[i] = max(f[i], f[j] + 1);
			ans = max(ans, f[i]);
		}
		for (int i = n; i >= 1; i--) {
			f[i] = 1;
			for (int j = n; j > i; j--) if (h[i] < h[j]) f[i] = max(f[i], f[j] + 1);
			ans = max(ans, f[i]);
		}

		printf("%d\n", ans);
	}
}