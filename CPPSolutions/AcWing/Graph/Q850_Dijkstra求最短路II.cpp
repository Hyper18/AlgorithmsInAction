using namespace std;
#include <iostream>
#include <cstring>
#include <queue>

const int N = 1.5e5+10, INF = 0x3f3f3f3f;

typedef pair<int, int> PII;

int n, m;
int h[N], e[N], ne[N], w[N], idx;
int d[N];
bool vis[N];

void addEdge(int a, int b, int c) {
	e[idx] = b;
	w[idx] = c;
	ne[idx] = h[a];
	h[a] = idx++;
}

int dijkstra() {
	memset(d, INF, sizeof d);
	d[1] = 0;

	priority_queue<PII, vector<PII>, greater<PII>> q;
	/*
		j和dist[j]的存储顺序和使用顺序是不能调换的
		具体关系到小根堆的使用性质:
		既然按照键值对最小值排序，
		那只能按照一种顺序排序,按照键值对的前一个值取最小值
	*/ 
	q.push({ 0, 1 });
	while (!q.empty()) {
		auto pos = q.top();
		q.pop();

		int u = pos.second, dis = pos.first;
		if (vis[u]) continue;
		vis[u] = true;
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (d[j] > dis + w[i]) {
				d[j] = dis + w[i];
			}
			q.push({ d[j], j });
		}
	}

	return d[n] == INF ? -1 : d[n];
}

int main() {
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	while (m--) {
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		addEdge(a, b, c);
	}
	printf("%d", dijkstra());
}