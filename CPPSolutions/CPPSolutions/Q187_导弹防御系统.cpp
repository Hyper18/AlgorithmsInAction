using namespace std;
#include <iostream>

const int N = 55;
int h[N], up[N], down[N];
int n, ans;

void dfs(int u, int su, int sd) {
	if (su + sd >= ans) return;
	if (u == n) {
		ans = min(ans, su + sd);
		return;
	}

	// 情况1：将当前数放到上升子序列中
	int k = 0;
	while (k < su && up[k] >= h[u]) k++;
	if (k < su) {
		int t = up[k];
		up[k] = h[u];
		dfs(u + 1, su, sd);
		up[k] = t;
	}
	else {
		up[k] = h[u];
		dfs(u + 1, su + 1, sd);
	}

	// 情况2：将当前数放到下降子序列中
	k = 0;
	while (k < sd && down[k] <= h[u]) k++;
	if (k < sd) {
		int t = down[k];
		down[k] = h[u];
		dfs(u + 1, su, sd);
		down[k] = t;
	}
	else {
		down[k] = h[u];
		dfs(u + 1, su, sd + 1);
	}
}

int main() {
	while (cin >> n, n) {
		for (int i = 0; i < n; i++) cin >> h[i];
		ans = n;
		dfs(0, 0, 0);
		cout << ans << endl;
	}
}