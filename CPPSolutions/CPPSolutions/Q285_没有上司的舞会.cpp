using namespace std;
#include <iostream>
#include <cstring>

const int N = 6010;

int n, idx;
int h[N], e[N], ne[N], w[N];
bool hasPar[N];
int f[N][2];

void addEdge(int a, int b) {
	e[idx] = b;
	ne[idx] = h[a];
	h[a] = idx++;
}

void dfs(int u) {
	f[u][1] = w[u];
	for (int i = h[u]; i != -1; i = ne[i]) {
		int j = e[i];
		dfs(j);

		f[u][1] += f[j][0];
		f[u][0] += max(f[j][0], f[j][1]);
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
	memset(h, -1, sizeof h);
	for (int i = 0; i < n - 1; i++) {
		int a, b;
		scanf("%d%d", &a, &b);
		addEdge(b, a);
		hasPar[a] = true;
	}
	int root = 1;
	while (hasPar[root]) root++;
	dfs(root);
	printf("%d", max(f[root][0], f[root][1]));
}