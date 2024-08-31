using namespace std;

#include <iostream>
#include <algorithm>

const int N = 1e5 + 10, M = N * 2, INF = 0x3f3f3f3f;

struct Edge {
    int a, b, c;

    // 类比Comparable.compareTo()
    bool operator<(const Edge &o) const {
        return c < o.c;
    }
} edges[M];

int n, m;
int p[N];

int find(int x) {
    if (x != p[x]) p[x] = find(p[x]);
    return p[x];
}

int kruskal() {
    sort(edges, edges + m);
    for (int i = 1; i <= n; i++) p[i] = i;

    int ans = 0, cnt = 0;
    for (int i = 0; i < m; i++) {
        int a = edges[i].a, b = edges[i].b, c = edges[i].c;
        a = find(a), b = find(b);
        if (a != b) {
            p[a] = b;
            ans += c;
            cnt++;
        }
    }

    return cnt < n - 1 ? INF : ans;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        edges[i] = {a, b, c};
    }
    int ans = kruskal();
    if (ans == INF) printf("impossible");
    else printf("%d", ans);
}
