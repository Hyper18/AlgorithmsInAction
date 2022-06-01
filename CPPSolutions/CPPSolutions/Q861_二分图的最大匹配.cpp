using namespace std;
#include <iostream>
#include <cstring>

const int N = 510, M = 1e5 + 10;

int n1, n2, m;
int h[N], e[M], ne[M], idx;
int match[N];
bool vis[N];

void addEdge(int a, int b) {
	e[idx] = b;
	ne[idx] = h[a];
	h[a] = idx++;
}

bool find(int x) {
	for (int i = h[x]; i != -1; i = ne[i]) {
		int j = e[i];
		if (vis[j]) continue;
		vis[j] = true;
		if (!match[j] || find(match[j])) {
			match[j] = x;
			return true;
		}
	}
	
	return false;
}

int main() {
	scanf("%d%d%d", &n1, &n2, &m);
	memset(h, -1, sizeof h);
	while (m--) {
		int a, b;
		scanf("%d%d", &a, &b);
		addEdge(a, b);
	}
	int ans = 0;
	for (int i = 1; i <= n1; i++) {
		if (find(i)) {
			memset(vis, 0, sizeof vis);
			ans++;
		}
	}
	printf("%d", ans);
}