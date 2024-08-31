using namespace std;

#include <iostream>
#include <cstring>

const int M = 1e3 + 10, N = 10 + 3;
char s[M][N];
int f[N][N];
int n, m;

int editDistance(char a[], char b[]) {
    int lenA = strlen(a + 1);
    int lenB = strlen(b + 1);
    for (int i = 0; i <= lenA; i++) {
        f[i][0] = i;
    }
    for (int j = 0; j <= lenB; j++) {
        f[0][j] = j;
    }

    for (int i = 1; i <= lenA; i++) {
        for (int j = 1; j <= lenB; j++) {
            f[i][j] = a[i] == b[j] ? f[i - 1][j - 1] : min(min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
        }
    }

    return f[lenA][lenB];
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++) {
        scanf("%s", s[i] + 1);
    }
    while (m--) {
        char q[N];
        int limit;
        scanf("%s%d", q + 1, &limit);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (editDistance(s[i], q) <= limit) {
                ans++;
            }
        }
        printf("%d\n", ans);
    }
}