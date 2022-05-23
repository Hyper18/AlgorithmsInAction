using namespace std;
#include <iostream>

const int N = 30;

int n;
int v[N];
int f[N][N], path[N][N];

void dfs(int l, int r) {
	if (l > r) return;
	int k = path[l][r];
	printf("%d ", k);
	dfs(l, k - 1);
	dfs(k + 1, r);
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) scanf("%d", &v[i]);

	for (int len = 1; len <= n; len++) {
		for (int l = 1; l + len - 1 <= n; l++) {
			int r = l + len - 1;
			if (len == 1) {
				f[l][r] = v[l];
				path[l][r] = l;
			}
			else {
				for (int k = l; k <= r; k++) {
					int leftSubTrees = l == k ? 1 : f[l][k - 1];
					int rightSubTrees = r == k ? 1 : f[k + 1][r];
					int score = leftSubTrees * rightSubTrees + v[k];
					if (score > f[l][r]) {
						f[l][r] = score;
						path[l][r] = k;
					}
				}
			}
		}
	}

	printf("%d\n", f[1][n]);
	dfs(1, n);
}