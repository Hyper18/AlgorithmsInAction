using namespace std;
#include <iostream>
#include <cstring>

const int N = 20 + 3;

int n, ans;
string w[N];
int cnt[N], l[N][N];

void dfs(string dragon, int last) {
	ans = max(ans, (int)dragon.size()); // ×¢ÒâÇ¿×ª·ÀÖ¹CE
	cnt[last]++;
	for (int i = 0; i < n; i++)
		if (l[last][i] && cnt[i] < 2)
			dfs(dragon + w[i].substr(l[last][i]), i);
	cnt[last]--;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) cin >> w[i];
	char c;
	cin >> c;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int a = w[i].size(), b = w[j].size();
			for (int k = 1; k < min(a, b); k++) {
				if (w[i].substr(a - k) == w[j].substr(0, k)) {
					l[i][j] = k;
					break;
				}
			}
		}
	}
	for (int i = 0; i < n; i++) 
		if (c == w[i][0])
			dfs(w[i], i);
	cout << ans;
}