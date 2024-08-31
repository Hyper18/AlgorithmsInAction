using namespace std;

#include <iostream>

const int N = 110;
int f[N][N];
int n, V, M;

int main() {
    scanf("%d%d%d", &n, &V, &M);
    for (int i = 0; i < n; i++) {
        int v, m, w;
        scanf("%d%d%d", &v, &m, &w);
        for (int j = V; j >= v; j--) {
            for (int k = M; k >= m; k--) {
                f[j][k] = max(f[j][k], f[j - v][k - m] + w);
            }
        }
    }
    printf("%d", f[V][M]);
}