#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 100010, MOD = 1e9 + 7;

int fact[N], infact[N];

int qmi(int a, int k, int p) {
	int ans = 1;
	while (k) {
		if (k & 1) ans = (LL)ans * a % p;
		a = (LL)a * a % p;
		k >>= 1;
	}

	return ans;
}

void init() {
	fact[0] = infact[0] = 1;
	for (int i = 1; i < N; i++) {
		fact[i] = (LL)fact[i - 1] * i % MOD;
		infact[i] = (LL)infact[i - 1] * qmi(i, MOD - 2, MOD) % MOD;
	}
}

int main() {
	init();

	int n;
	scanf("%d", &n);
	while (n--) {
		int a, b;
		scanf("%d%d", &a, &b);
		printf("%d\n", (LL)fact[a] * infact[a - b] % MOD * infact[b] % MOD);
	}

	return 0;
}