#pragma once

typedef int ElemType;

// ÷±Ω”≤Â»Î≈≈–Ú
void insertSort(ElemType a[], int n) {
	int i, j;
	for (int i = 2; i <= n; i++) {
		if (a[i] < a[i - 1]) {
			a[0] = a[i];         // a[0]: sentinel
			for (int j = i - 1; a[j] > a[0]; j--)
				a[j + 1] = a[j]; // shift right
			a[j + 1] = a[0];	 // insert
		}
	}
}