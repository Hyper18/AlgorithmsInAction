#pragma once
using namespace std;
#include <iostream>

const int N = 10e5 + 10;
int q[N], tmp[N];

void mergeSort(int q[], int l, int r) {
    if (l >= r) {
        return;
    }
    int mid = l + ((r - l) >> 1);
    mergeSort(q, l, mid);
    mergeSort(q, mid + 1, r);

    int k = 0, i = l, j = mid + 1;
    while (i <= mid && j <= r) {
        if (q[i] <= q[j]) {
            tmp[k++] = q[i++];
        }
        else {
            tmp[k++] = q[j++];
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
}
