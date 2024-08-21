using namespace std;
#include <iostream>
#include <cstring>
#include <algorithm>

const int N = 1e5 + 10, M = N * 2;

int n, m;
int h[N], e[M], ne[M], idx;
int color[N];

void addEdge(int a, int b) {
	e[idx] = b;
	ne[idx] = h[a];
	h[a] = idx++;
}

bool dfs(int u,int c) {
	color[u] = c;
	for (int i = h[u]; i != -1; i = ne[i]) {
		int j = e[i];
		if (!color[j]) {
			if (!dfs(j, 3 - c)) return false;
		}
		else if (color[j] == c) return false;
	}

	return true;
}

int main() {
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	while (m--) {
		int a, b;
		scanf("%d%d", &a, &b);
		addEdge(a, b), addEdge(b, a);
	}
	bool flag = true;
	for (int i = 1; i <= n; i++) {
		if (!color[i]) {
			if (!dfs(i, 1)) {
				flag = false;
				break;
			}
		}
	}
	printf(flag ? "Yes" : "No");
}