using namespace std;
#include <iostream>

int lowbit(int x) {
	return x & -x;
}

int main() {
	int n;
	scanf("%d", &n);

	while (n--) {
		int x;
		scanf("%d", &x);

		int ans = 0;
		while (x) {
			x -= lowbit(x);
			ans++;
		}
		printf("%d ", ans);
	}
}