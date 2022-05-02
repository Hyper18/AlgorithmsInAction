using namespace std;
#include <iostream>

const int N = 10e5 + 10;

int q[N];

int quickSort(int l, int r, int k) {
	if (l >= r) {
		return q[l];
	}
	int x = q[l + ((r - l) >> 1)];
	int i = l - 1, j = r + 1;
	while (i < j) {
		do {
			i++;
		} while (q[i] < x);
		do {
			j--;
		} while (q[j] > x);
		if (i < j) {
			swap(q[i], q[j]);
		}
	}
	if (j - l + 1 >= k) {
		quickSort(l, j, k);
	}
	else {
		return quickSort(j + 1, r, k - (j - l + 1));
	}
}

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &q[i]);
	}

	int ans = quickSort(0, n - 1, k);

	printf("%d", ans);
}