using namespace std;

#include <iostream>

const int N = 2e4 + 10;
int f[N];
int m, n;

int main() {
    scanf("%d%d", &m, &n);
    for (int i = 1; i <= n; i++) {
        int v;
        scanf("%d", &v);
        for (int j = m; j >= v; j--) f[j] = max(f[j], f[j - v] + v);
    }
    printf("%d", m - f[m]);
}