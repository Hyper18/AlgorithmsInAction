using namespace std;
#include<iostream>
#include<vector>

typedef long long LL;

const int N = 12, M = 1 << 10, K = 110;

vector<int> states, head[M];
LL f[N][K][M];
int cnt[M];
int n, m;

bool check(int st) {
	for (int i = 0; i < n; i++)
		if ((st >> i & 1) && (st >> i + 1 & 1))
			return 0;
	return 1;
}

int count(int st) {
	int ans = 0;
	for (int i = 0; i < n; i++) ans += st >> i & 1;
	return ans;
}

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < 1 << n; i++) {
		if (check(i)) {
			states.push_back(i);
			cnt[i] = count(i);
		}
	}
	for (int i = 0; i < states.size(); i++) {
		for (int j = 0; j < states.size(); j++) {
			int a = states[i], b = states[j];
			if ((a & b) == 0 && check(a | b)) {
				head[i].push_back(j);
			}
		}
	}

	f[0][0][0] = 1;
	for (int i = 1; i <= n + 1; i++) {
		for (int j = 0; j <= m; j++) {
			for (int a = 0; a < states.size(); a++) {
				for (int b : head[a]) {
					int c = cnt[states[a]];
					if (j >= c) {
						f[i][j][a] += f[i - 1][j - c][b];
					}
				}
			}
		}
	}

	printf("%lld", f[n + 1][m][0]);
}