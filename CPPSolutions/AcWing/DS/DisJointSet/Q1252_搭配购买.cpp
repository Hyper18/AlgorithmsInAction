using namespace std;

#include <iostream>

const int N = 10010;

int n, m, q;
int p[N], v[N], w[N];
int f[N];

int find(int x) {
    if (x != p[x]) p[x] = find(p[x]);
    return p[x];
}

int main() {
    scanf("%d%d%d", &n, &m, &q);
    for (int i = 1; i <= n; i++) {
        p[i] = i;
        scanf("%d%d", &v[i], &w[i]);
    }
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            v[pb] += v[pa];
            w[pb] += w[pa];
            p[pa] = pb;
        }
    }

    for (int i = 1; i <= n; i++) {
        if (p[i] != i) continue;
        for (int j = q; j >= v[i]; j--) {
            f[j] = max(f[j], f[j - v[i]] + w[i]);
        }
    }
    printf("%d", f[q]);
}