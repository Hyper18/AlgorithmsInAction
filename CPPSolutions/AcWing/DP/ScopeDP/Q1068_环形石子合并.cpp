using namespace std;
#include <iostream>
#include <cstring>

const int N = 410, INF = 0x3f3f3f3f;

int n;
int a[N], pre[N];
int f[N][N], g[N][N];

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &a[i]);
		a[i + n] = a[i];
	}
	for (int i = 1; i <= n * 2; i++) pre[i] = pre[i - 1] + a[i];

	memset(f, INF, sizeof f);
	memset(g, -INF, sizeof g);
	for (int len = 1; len <= n; len++) {
		for (int l = 1; l + len - 1 <= n * 2; l++) {
			int r = l + len - 1;
			if (len == 1) f[l][r] = g[l][r] = 0;
			else {
				for (int k = l; k < r; k++) {
					f[l][r] = min(f[l][r], f[l][k] + f[k + 1][r] + pre[r] - pre[l - 1]);
					g[l][r] = max(g[l][r], g[l][k] + g[k + 1][r] + pre[r] - pre[l - 1]);
				}
			}
		}
	}
	
	int minv = INF, maxv = -INF;
	for (int l = 1; l <= n; l++) {
		int r = l + n - 1;
		if (f[l][r] < minv) minv = f[l][r];
		if (g[l][r] > maxv) maxv = g[l][r];
	}
	printf("%d\n%d", minv, maxv);
}