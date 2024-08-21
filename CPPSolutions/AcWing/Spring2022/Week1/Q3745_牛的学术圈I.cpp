using namespace std;
#include <algorithm>
#include <iostream>

const int N = 10e5 + 10;
int n, L;
int c[N];

int main() {
	scanf("%d %d", &n, &L);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &c[i]);
	}

	sort(c + 1, c + n + 1, greater<int>());

	int ans = 0;
	for (int i = 1, j = n; i <= n; i++) {
		while (j > 0 && c[j] < i) {
			j--;
		}
		if (c[i] >= i - 1 && i - j <= L) {
			ans = i;
		}
	}

	printf("%d", ans);
}