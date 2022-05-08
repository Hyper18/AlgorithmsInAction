using namespace std;
#include <iostream>

const int N = 110;
int f[N][N];

int main() {
	int n;
	scanf("%d", &n);
	while (n--) {
		int r, c;
		scanf("%d%d", &r, &c);
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				int w;
				scanf("%d", &w);
				f[i][j] = max(f[i - 1][j], f[i][j - 1]) + w;
			}
		}
		printf("%d\n", f[r][c]);
	}
}