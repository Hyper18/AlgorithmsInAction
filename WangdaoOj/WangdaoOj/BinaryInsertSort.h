#pragma once
typedef int ElemType;

void insertSort(ElemType a[], int n) {
	int i, j, low, high, mid;
	for (int i = 2; i <= n; i++) {
		a[0] = a[i];

		low = 1, high = i - 1;
		while (low <= high) {
			mid = low + ((high - low) >> 1);
			if (a[mid] > a[0]) high = mid - 1;
			else low = mid + 1;
		}
		for (j = i - 1; j >= high - 1; --j) {
			a[j + 1] = a[j]; // shift right
		}
		a[high + 1] = a[0];
	}
}