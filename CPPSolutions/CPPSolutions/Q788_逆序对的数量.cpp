using namespace std;
#include <iostream>

typedef long long LL;

const int N = 10e5 + 10;
int q[N], tmp[N];
int n;

LL mergeSort(int l, int r) {
	if (l >= r) {
		return 0;
	}
	int mid = l + ((r - l) >> 1);
	LL ans = mergeSort(l, mid) + mergeSort(mid + 1, r);
	int k = 0, i = l, j = mid + 1;
	while (i <= mid && j <= r) {
		if (q[i] <= q[j]) {
			tmp[k++] = q[i++];
		}
		else {
			tmp[k++] = q[j++];
			ans += mid - i + 1;
		}
	}
	while (i <= mid) {
		tmp[k++] = q[i++];
	}
	while (j <= r) {
		tmp[k++] = q[j++];
	}
	for (i = l, j = 0; i <= r; i++, j++) {
		q[i] = tmp[j];
	}
	
	return ans;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &q[i]);
	}
	
	printf("%ld", mergeSort(0, n - 1));
}