using namespace std;
#include <iostream>
#include <cstring>

const int N = 1e5 + 10, M = N * 2;
int n, idx, ans;
int h[N], e[M], ne[M], w[M];
bool vis[N];

void addEdge(int a, int b, int c) {
	e[idx] = b;
	w[idx] = c;
	ne[idx] = h[a];
	h[a] = idx++;
}

int dfs(int u) {
	vis[u] = true;
	
	int dis = 0, seg1 = 0, seg2 = 0;
	for (int i = h[u]; i != -1; i = ne[i]) {
		int j = e[i];
		if (vis[j]) continue;
		
		int d = dfs(j) + w[i];
		dis = max(dis, d);

		if (d >= seg1) {
			seg2 = seg1;
			seg1 = d;
		}
		else if (d > seg2) seg2 = d;
	}
	ans = max(ans, seg1 + seg2);

	return dis;
}

int main() {
	scanf("%d", &n);
	memset(h, -1, sizeof h);
	for (int i = 0; i < n - 1; i++) {
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		addEdge(a, b, c);
		addEdge(b, a, c);
	}
	dfs(1);
	printf("%d", ans);
}