using namespace std;

#include <iostream>

const int N = 10;
char g[N][N];
bool row[N], col[N], dg[N * 2], udg[N * 2];
int n;

void dfs(int x, int y, int s) {
    if (s > n) {
        return;
    }
    if (y == n) {
        x++;
        y = 0;
    }
    if (x == n) {
        if (s == n) {
            for (int i = 0; i < n; i++) {
                puts(g[i]);
            }
            puts("");
        }
        return;
    }

    g[x][y] = '.';
    dfs(x, y + 1, s);

    if (!(row[x] || col[y] || dg[x + y] || udg[n - x + y])) {
        g[x][y] = 'Q';
        row[x] = col[y] = dg[x + y] = udg[n - x + y] = true;
        dfs(x, y + 1, s + 1);
        row[x] = col[y] = dg[x + y] = udg[n - x + y] = false;
        g[x][y] = '.';
    }
}

int main() {
    scanf("%d", &n);
    dfs(0, 0, 0);
}