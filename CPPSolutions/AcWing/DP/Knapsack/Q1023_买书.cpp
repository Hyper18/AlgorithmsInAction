using namespace std;

#include <iostream>

const int N = 1e3 + 10;
const int v[6] = {0, 10, 20, 50, 100};
int f[N];
int n;

int main() {
    scanf("%d", &n);
    f[0] = 1;
    for (int i = 1; i < 5; i++) {
        for (int j = v[i]; j <= n; j++) {
            f[j] += f[j - v[i]];
        }
    }
    printf("%d", f[n]);
}