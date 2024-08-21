#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;

int qmi(int a, int k, int p) {
	int ans = 1;
	while (k) {
		if (k & 1) ans = (LL)ans * a % p;
		a = (LL)a * a % p;
		k >>= 1;
	}

	return ans;
}

int C(int a, int b, int p) {
	if (b > a) return 0;
	
	int ans = 1;
	for (int i = 1, j = a; i <= b; i++, j--) {
		ans = (LL)ans * j % p;
		ans = (LL)ans * qmi(i, p - 2, p) % p;
	}

	return ans;
}

int lucas(LL a, LL b, int p) {
	if (a < p && b < p) return C(a, b, p);
	return (LL)C(a % p, b % p, p) * lucas(a / p, b / p, p) % p;
}

int main() {
	int n;
	scanf("%d", &n);
	while (n--) {
		LL a, b;
		int p;
		scanf("%lld%lld%d", &a, &b, &p);
		printf("%d\n", lucas(a, b, p));
	}

	return 0;
}