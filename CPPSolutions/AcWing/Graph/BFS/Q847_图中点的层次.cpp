using namespace std;
#include <iostream>
#include <cstring>
#include <queue>

const int N = 1e5 + 10;

int n, m, idx;
int h[N], e[N], ne[N], d[N];

void addEdge(int a, int b) {
	e[idx] = b;
	ne[idx] = h[a];
	h[a] = idx++;
}

int bfs() {
	memset(d, -1, sizeof d);
	d[1] = 0;

	queue<int> q;
	q.push(1);
	while (!q.empty()) {
		int u = q.front();
		q.pop();

		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (d[j] != -1) continue;

			d[j] = d[u] + 1;
			q.push(j);
		}
	}

	return d[n];
}

int main() {
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	while (m--) {
		int a, b;
		scanf("%d%d", &a, &b);
		addEdge(a, b);
	}
	printf("%d", bfs());
}