using namespace std;

#include <iostream>

const int N = 10;

int path[N];
int n;

void dfs(int k, int st) {
    if (k == n) {
        for (int i = 0; i < n; i++) {
            printf("%d ", path[i]);
        }
        puts("");
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!(st >> i & 1)) {
            path[k] = i + 1;
            dfs(k + 1, st + (1 << i));
        }
    }
}

int main() {
    scanf("%d", &n);
    dfs(0, 0);
}