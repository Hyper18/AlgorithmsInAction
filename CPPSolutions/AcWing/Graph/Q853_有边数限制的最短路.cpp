using namespace std;

#include <iostream>
#include <cstring>

const int N = 510, M = 1e4 + 10, INF = 0x3f3f3f3f;

int n, m, k;
int d[N], t[N];

struct Edge {
    int a, b, c;
} edges[M];

void bellmanFord() {
    memset(d, INF, sizeof d);
    d[1] = 0;

    for (int i = 0; i < k; i++) {
        memcpy(t, d, sizeof d);
        for (int j = 0; j < m; j++) {
            auto e = edges[j];
            d[e.b] = min(d[e.b], t[e.a] + e.c);
        }
    }
}

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < m; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        edges[i] = {a, b, c};
    }
    bellmanFord();
    if (d[n] > INF / 2)
        printf("impossible");
    else printf("%d", d[n]);
}