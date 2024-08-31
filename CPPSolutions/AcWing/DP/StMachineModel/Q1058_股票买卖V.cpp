using namespace std;

#include <iostream>
#include <cstring>

const int N = 1e5 + 10, INF = 0x3f3f3f3f;
int w[N], f[N][3];
int n;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
    memset(f, -INF, sizeof f);
    f[0][0] = 0;
    for (int i = 1; i <= n; i++) {
        f[i][0] = max(f[i - 1][0], f[i - 1][2]);
        f[i][1] = max(f[i - 1][1], f[i - 1][0] - w[i]);
        f[i][2] = f[i - 1][1] + w[i];
    }
    printf("%d", max(f[n][0], f[n][2]));
}
