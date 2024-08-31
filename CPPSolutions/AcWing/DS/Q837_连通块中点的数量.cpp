using namespace std;

#include <iostream>

const int N = 1e5 + 10;

int a, b;
string op;
int p[N], cnt[N];

int find(int x) {
    if (x != p[x]) p[x] = find(p[x]);
    return p[x];
}

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        p[i] = i;
        cnt[i]++;
    }
    while (m--) {
        cin >> op >> a;
        if (op == "C") {
            cin >> b;
            int p1 = find(a), p2 = find(b);
            if (p1 != p2) {
                p[p1] = p2;
                cnt[p2] += cnt[p1];
            }
        } else if (op == "Q1") {
            cin >> b;
            printf(find(a) == find(b) ? "Yes\n" : "No\n");
        } else printf("%d\n", cnt[find(a)]);
    }
}