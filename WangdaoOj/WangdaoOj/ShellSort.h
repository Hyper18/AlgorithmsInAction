#pragma once
typedef int ElemType;

void shellSort(ElemType a[], int n) {
	int dk, i, j;
	for (dk = n / 2; dk >= 1; dk /= 2) {
		for (i = dk + 1; i <= n; i++) {
			if (a[i] < a[i - dk]) {
				a[0] = a[i];
				for (j = i - dk; j > 0 && a[0] < a[j]; j -= dk)
					a[j + dk] = a[j];
				a[j + dk] = a[0];
			}
		}
	}
}