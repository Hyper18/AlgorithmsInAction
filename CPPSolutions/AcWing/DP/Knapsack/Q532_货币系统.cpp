using namespace std;

#include <iostream>
#include <algorithm>
#include <cstring>

const int N = 25010;
int a[N];
bool f[N];

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        for (int i = 0; i < n; i++) scanf("%d", &a[i]);

        sort(a, a + n);
        memset(f, 0, sizeof f);
        f[0] = 1;
        int ans = 0, m = a[n - 1];
        for (int i = 0; i < n; i++) {
            if (!f[a[i]]) ans++;
            for (int j = a[i]; j <= m; j++) {
                f[j] |= f[j - a[i]];
            }
        }
        printf("%d\n", ans);
    }
}