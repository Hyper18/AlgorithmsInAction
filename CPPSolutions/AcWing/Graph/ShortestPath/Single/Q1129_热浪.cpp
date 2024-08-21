using namespace std;
#include <iostream>
#include <cstring>

const int N = 2510, M = 6200 * 2 + 10, INF = 0x3f3f3f3f;

int n, m, st, ed;
int h[N], e[M], ne[M], w[M], idx;
int d[N], q[N];
bool vis[N];

void addEdge(int a, int b, int c) {
	e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void spfa() {
	memset(d, INF, sizeof d);
	d[st] = 0;
	
	int hh = 0, tt = 1;
	q[0] = st;
	vis[st] = true;
	while (hh != tt) {
		int u = q[hh++];
		if (hh == N) hh = 0;
		vis[u] = false;
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (d[j] > d[u] + w[i]) {
				d[j] = d[u] + w[i];
				if (vis[j]) continue;
				vis[j] = true;
				q[tt++] = j;
				if (tt == N) tt = 0;
			}
		}
	}
}

int main() {
	scanf("%d%d%d%d", &n, &m, &st, &ed);
	memset(h, -1, sizeof h);
	while (m--) {
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		addEdge(a, b, c), addEdge(b, a, c);
	}
	spfa();
	printf("%d", d[ed]);
}