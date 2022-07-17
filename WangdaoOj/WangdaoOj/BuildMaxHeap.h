#pragma once
#include <iostream>

using namespace std;

typedef int ElemType;

void buildMaxHeap(ElemType a[], int len) {
	for (int i = len / 2; i > 0; i--) {
		heapAdjust(a, i, len);
	}
}

void heapAdjust(ElemType a[], int k, int len) {
	a[0] = a[k];
	for (int i = 2 * k; i <= len; i *= 2) {
		if (i < len && a[i] < a[i + 1]) i++;
		if (a[0] >= a[i]) break;
		else {
			a[k] = a[i];
			k = i;
		}
	}
	a[k] = a[0];
}

void heapSort(ElemType a[], int len) {
	buildMaxHeap(a, len);
	for (int i = len; i > 1; i--) {
		swap(a[i], a[1]);
		heapAdjust(a, 1, i - 1);
	}
}