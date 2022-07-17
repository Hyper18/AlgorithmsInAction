#pragma once
#include <iostream>

using namespace std;

typedef int ElemType;

void selectSort(ElemType a[], int n) {
	for (int i = 0; i < n - 1; i++) {
		int min = a[i];
		for (int j = i + 1; j < n; j++)
			if (a[j] < a[min]) min = j;
		if (min != i) swap(a[i], a[min]);
	}
}