using namespace std;
#include <iostream>
#include <cstring>

const int N = 1e5 + 10, M = N * 2;

int n, idx, ans = N;
int h[N], e[M], ne[M];
bool vis[N];

void addEdge(int a, int b) {
	e[idx] = b;
	ne[idx] = h[a];
	h[a] = idx++;
}

int dfs(int u) {
	vis[u] = true;

	int size = 0, sum = 0;
	for (int i = h[u]; i != -1; i = ne[i]) {
		int j = e[i];
		if (vis[j]) continue;

		int s = dfs(j);
		size = max(size, s);
		sum += s;
	}
	size = max(size, n - (sum + 1));
	ans = min(ans, size);

	return sum + 1;
}

int main() {
	scanf("%d", &n);
	memset(h, -1, sizeof h);
	for (int i = 0; i < n - 1; i++) {
		int a, b;
		scanf("%d%d", &a, &b);
		addEdge(a, b);
		addEdge(b, a);
	}
	dfs(1);
	printf("%d", ans);
}