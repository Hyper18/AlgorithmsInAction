using namespace std;
#include <iostream>

const int N = 10e5 + 10;
int q[N];
int n, Q, k;

int main() {
	scanf("%d %d", &n, &Q);
	for (int i = 0; i < n; i++) {
		scanf("%d", &q[i]);
	}
	while (Q--) {
		scanf("%d", &k);
		int l = 0, r = n - 1;
		while (l < r) {
			int mid = l + ((r - l) >> 1);
			if (q[mid] >= k) {
				r = mid;
			}
			else {
				l = mid + 1;
			}
		}

		if (q[l] != k) {
			printf("%d %d\n", -1, -1);
		}
		else {
			printf("%d ", l);

			int l = 0, r = n - 1;
			while (l < r) {
				int mid = l + ((r - l + 1) >> 1);
				if (q[mid] <= k) {
					l = mid;
				}
				else {
					r = mid - 1;
				}
			}

			printf("%d\n", l);
		}
	}
}