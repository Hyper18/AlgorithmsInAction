using namespace std;
#include <iostream>

const int N = 1e3 + 10;
int pre[N][N];
int n, m, q, x1, y1, x2, y2;

int main() {
	scanf("%d %d %d", &n, &m, &q);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &pre[i][j]);
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
		}
	}

	while (q--) {
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		printf("%d\n", pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1]);
	}
}