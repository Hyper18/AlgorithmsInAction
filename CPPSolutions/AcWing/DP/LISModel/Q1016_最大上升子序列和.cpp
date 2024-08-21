using namespace std;
#include <iostream>

const int N = 1010;
int a[N], f[N];
int n;

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) scanf("%d", &a[i]);

	int ans = 0;
	for (int i = 1; i <= n; i++) {
		f[i] = a[i];
		for (int j = 1; j < i; j++) if (a[i] > a[j]) f[i] = max(f[i], f[j] + a[i]);
		ans = max(ans, f[i]);
	}

	printf("%d", ans);
}