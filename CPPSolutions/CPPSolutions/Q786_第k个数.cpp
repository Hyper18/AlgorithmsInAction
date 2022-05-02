using namespace std;
#include <iostream>

const int N = 10e5 + 10;

int q[N];

void quickSort(int l, int r) {
	if (l >= r) {
		return;
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
	quickSort(l, j);
	quickSort(j + 1, r);
}

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &q[i]);
	}

	quickSort(0, n - 1);

	printf("%d", q[k - 1]);
}