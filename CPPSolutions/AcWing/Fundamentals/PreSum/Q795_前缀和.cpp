using namespace std;

#include <iostream>

const int N = 1e5 + 10;
int pre[N];
int n, m, k, l, r;

int main() {
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &k);
        pre[i] = pre[i - 1] + k;
    }

    while (m--) {
        scanf("%d %d", &l, &r);
        printf("%d\n", pre[r] - pre[l - 1]);
    }
}