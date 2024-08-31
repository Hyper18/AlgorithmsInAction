using namespace std;

#include <iostream>

const int N = 1e5 + 10;
int a[N], q[N];
int n;

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    int len = 0;
    for (int i = 0; i < n; i++) {
        int l = 0, r = len;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (q[mid] < a[i]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        len = max(len, r + 1);
        q[r + 1] = a[i];
    }

    printf("%d", len);
}