using namespace std;

#include <iostream>
#include <algorithm>

const int N = 5010;

typedef pair<int, int> PII;

PII a[N];
int f[N];
int n;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%d%d", &a[i].first, &a[i].second);

    sort(a + 1, a + 1 + n);
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        f[i] = 1;
        for (int j = 1; j < i; j++) if (a[i].second > a[j].second) f[i] = max(f[i], f[j] + 1);
        ans = max(ans, f[i]);
    }

    printf("%d", ans);
}