using namespace std;
#include <iostream>
#include <cstring>
#include <queue>

const int N = 2010, M = 10010;

int n, m;
int h[N], e[M], ne[M], w[M], idx;
int d[N], cnt[N];
bool vis[N];

void addEdge(int a, int b, int c) {
	e[idx] = b;
	w[idx] = c;
	ne[idx] = h[a];
	h[a] = idx++;
}

bool spfa() {
	queue<int> q;
	for (int i = 1; i <= n; i++) {
		q.push(i);
		vis[i] = true;
	}

	while (!q.empty()) {
		int u = q.front();
		q.pop();
		vis[u] = false;

		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (d[j] > d[u] + w[i]) {
				d[j] = d[u] + w[i];
				cnt[j] = cnt[u] + 1;
				if (cnt[j] >= n) return true;
				if (vis[j]) continue;
				q.push(j);
				vis[j] = true;
			}
		}
	}

	return false;
}

int main() {
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	while (m--) {
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		addEdge(a, b, c);
	}
	printf(spfa() ? "Yes" : "No");
}