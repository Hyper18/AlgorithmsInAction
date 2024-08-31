using namespace std;

#include <iostream>
#include <cstring>

const int N = 1e5 + 10;

int n, m;
int h[N], e[N], ne[N], idx;
int d[N], q[N];

void addEdge(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}

bool topSort() {
    int hh = 0, tt = -1;
    for (int i = 1; i <= n; i++)
        if (!d[i]) q[++tt] = i;

    while (hh <= tt) {
        int u = q[hh++];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!--d[j]) q[++tt] = j;

        }
    }

    return tt == n - 1;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        addEdge(a, b);
        d[b]++;
    }
    if (topSort())
        for (int i = 0; i < n; i++)
            printf("%d ", q[i]);
    else puts("-1");
}