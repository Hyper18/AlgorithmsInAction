using namespace std;

#include <iostream>

const int N = 1e3 + 10, mod = 1e9 + 7;
int f[N];
int n;

int main() {
    scanf("%d", &n);
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            f[j] = (f[j] + f[j - i]) % mod;
        }
    }
    printf("%d", f[n]);
}