#pragma once
#include <iostream>

using namespace std;

typedef int ElemType;

int maxbit(ElemType a[], int n) {
	int maxData = a[0];
	for (int i = 1; i < n; i++)
		maxData = max(maxData, a[i]);

	int d = 1, p = 10;
	while (maxData >= p)
		maxData /= 10, ++d;

	return d;
}

void radixSort(ElemType a[], int n) {
	int d = maxbit(a, n);
	int* tmp = new int[n], * count = new int[10];
	int i, j, k, radix = 1;
	for (i = 1; i <= d; i++) {
		for (j = 0; j < n; j++)
			count[j] = 0; // init
		for (j = 0; j < n; j++) {
			k = (a[j] / radix) % 10; // allocate
			count[k]++;
		}
		for (j = 1; j < 10; j++)
			count[j] += count[j - 1]; 
		for (j = n - 1; j >= 0; j--) {
			k = (a[j] / radix) % 10;
			tmp[count[k] - 1] = a[j]; // collect
			count[k]--;
		}
		for (j = 0; j < n; j++)
			a[j] = tmp[j]; 
		radix *= 10;
	}
	delete[]tmp, count;
}