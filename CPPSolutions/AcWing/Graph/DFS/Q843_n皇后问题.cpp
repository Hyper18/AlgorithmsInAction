using namespace std;

#include <iostream>

const int N = 10;
int n;
char g[N][N];
bool col[N], dg[N * 2], udg[N * 2];

void backtrack(int k) {
    if (k == n) {
        for (int i = 0; i < n; i++) {
            puts(g[i]);
        }
        puts("");
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!(col[i] || dg[k + i] || udg[n - k + i])) {
            g[k][i] = 'Q';
            col[i] = dg[k + i] = udg[n - k + i] = true;
            backtrack(k + 1);
            col[i] = dg[k + i] = udg[n - k + i] = false;
            g[k][i] = '.';
        }
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            g[i][j] = '.';
        }
    }
    backtrack(0);
}