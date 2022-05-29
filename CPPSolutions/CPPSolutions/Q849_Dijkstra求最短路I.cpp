using namespace std;
#include <iostream>
#include <cstring>

const int N = 510, INF = 0x3f3f3f3f;

int g[N][N], d[N];
bool vis[N];

int dijkstra(int n) {
	memset(d, INF, sizeof d);
	d[1] = 0;

	for (int i = 0; i < n - 1; i++) {
		int t = -1;
		for (int j = 1; j <= n; j++) {
			if (!vis[j] && (t == -1 || d[t] > d[j]))
				t = j;
		}

		vis[t] = true;
		for (int j = 1; j <= n; j++) {
			d[j] = min(d[j], d[t] + g[t][j]);
		}
	}

	return d[n] == INF ? -1 : d[n];
}

int main() {
	int n, m;
	scanf("%d%d", &n, &m);
	memset(g, INF, sizeof g);
	while (m--) {
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		g[a][b] = min(g[a][b], c);
	}
	printf("%d", dijkstra(n));
}