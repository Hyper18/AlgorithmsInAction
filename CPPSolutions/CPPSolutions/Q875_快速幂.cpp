#include <iostream>
#include <algorithm>

typedef long long LL;

using namespace std;

int qmi(int a, int k, int p) {
	LL ans = 1 % p; // ·ÀÖ¹pÎª1
	while (k) {
		if (k & 1) ans = ans * a % p;
		a = a * (LL)a % p;
		k >>= 1;
	}

	return ans;
}

int main() {
	int n;
	scanf("%d", &n);
	while (n--) {
		int a, b, p;
		scanf("%d%d%d", &a, &b, &p);
		printf("%lld\n", qmi(a, b, p));
	}

	return 0;
}