using namespace std;

#include <iostream>

const int N = 1e2 + 10;
int n, m;
int v[N], w[N], s[N];
int f[N];

int main() {
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= n; i++) {
        scanf("%d %d %d", &v[i], &w[i], &s[i]);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = m; j >= v[i]; j--) {
            for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                f[j] = max(f[j], f[j - k * v[i]] + k * w[i]);
            }
        }
    }

    printf("%d", f[m]);
}