using namespace std;

#include <iostream>

// 将多重背包问题拆分为01背包问题，采用二进制优化，则最多可拆分为1000 * log2(2000)件物品（注意：这里log以2为底）
const int N = 11000 + 10, M = 2e3 + 10;
int v[N], w[N], f[N];
int n, m;

int main() {
    scanf("%d %d", &n, &m);

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        int a, b, s;
        scanf("%d %d %d", &a, &b, &s);
        int k = 1;
        while (k <= s) {
            cnt++;
            v[cnt] = a * k;
            w[cnt] = b * k;
            s -= k;
            k <<= 1;
        }
        if (s > 0) {
            cnt++;
            v[cnt] = a * s;
            w[cnt] = b * s;
        }
    }

    n = cnt;
    for (int i = 1; i <= n; i++) {
        for (int j = m; j >= v[i]; j--) {
            f[j] = max(f[j], f[j - v[i]] + w[i]);
        }
    }

    printf("%d", f[m]);
}