using namespace std;
#include <iostream>
#include <cstring>

const int N = 110, M = N;

int n, m, idx;
int v[M], w[M];
int h[N], e[M], ne[M];
int f[N][N];

void addEdge(int a, int b) {
	e[idx] = b;
	ne[idx] = h[a];
	h[a] = idx++;
}

void dfs(int u) {
	for (int i = h[u]; i != -1; i = ne[i]) {
		dfs(e[i]);

		for (int j = m - v[u]; j >= 0; j--) {
			for (int k = 0; k <= j; k++) {
				f[u][j] = max(f[u][j], f[u][j - k] + f[e[i]][k]);
			}
		}
	}

	for (int i = m; i >= v[u]; i--) f[u][i] = f[u][i - v[u]] + w[u];
	for (int i = 0; i < v[u]; i++) f[u][i] = 0;
}

int main() {
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	int root;
	for (int i = 1; i <= n; i++) {
		int p;
		scanf("%d%d%d", &v[i], &w[i], &p);
		if (p == -1) root = i;
		else addEdge(p, i);
	}
	dfs(root);
	printf("%d", f[root][m]);
}