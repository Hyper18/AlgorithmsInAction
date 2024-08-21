using namespace std;
#include <iostream>
#include <vector>

const int N = 15, M = 1 << 12, MOD = 1e8;
vector<int> states, head[M];
int w[N], f[N][M];
int n, m;

bool check(int st) {
	for (int i = 0; i + 1 < m; i++)
		if ((st >> i & 1) && (st >> i + 1 & 1))
			return 0;
	return 1;
}

int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < m; j++) {
			int t;
			cin >> t;
			w[i] += !t * (1 << j);
		}
	}
	for (int i = 0; i < 1 << m; i++) if (check(i)) states.push_back(i);
	for (int i = 0; i < states.size(); i++) {
		for (int j = 0; j < states.size(); j++) {
			int a = states[i], b = states[j];
			if (!(a & b)) {
				head[i].push_back(j);
			}
		}
	}

	f[0][0] = 1;
	for (int i = 1; i <= n + 1; i++)
		for (int j = 0; j < states.size(); j++)
			if (!(states[j] & w[i]))
				for (int k : head[j])
					f[i][j] = (f[i][j] + f[i - 1][k]) % MOD;

	cout << f[n + 1][0];
}