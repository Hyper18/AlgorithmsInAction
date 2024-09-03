#include <iostream>

using namespace std;

typedef long long LL;

LL qmi(int a, int k, int p) {
    LL ans = 1;
    while (k) {
        if (k & 1) ans = ans * a % p;
        a = a * (LL) a % p;
        k >>= 1;
    }

    return ans;
}

int main() {
    int n;
    scanf("%d", &n);
    while (n--) {
        int a, p;
        scanf("%d%d", &a, &p);
        if (a % p == 0) puts("impossible");
        else printf("%lld\n", qmi(a, p - 2, p));
    }

    return 0;
}