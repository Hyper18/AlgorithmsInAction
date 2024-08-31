using namespace std;

#include <iostream>

const int N = 10;

int n, ans = N;
int p[N], groups[N][N];
bool vis[N];

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

bool check(int group[], int gc, int k) {
    for (int i = 0; i < gc; i++)
        if (gcd(p[group[i]], p[k]) > 1)
            return false;
    return true;
}

void dfs(int g, int k, int gc, int tc) {
    if (g >= ans) return;
    if (tc == n) ans = g;
    bool flag = true;
    for (int i = k; i < n; i++) {
        if (!vis[i] && check(groups[g], gc, i)) {
            flag = false;
            vis[i] = true;
            groups[g][gc] = i;
            dfs(g, i + 1, gc + 1, tc + 1);
            vis[i] = false;
        }
    }
    if (flag) dfs(g + 1, 0, 0, tc);
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &p[i]);
    dfs(1, 0, 0, 0);
    printf("%d", ans);
}