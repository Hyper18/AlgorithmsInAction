using namespace std;
#include <iostream>
#include <cstring>
#include <cmath>

const int N = 15, M = 9;
const double INF = 1e9;

int n, m = 8;
int pre[M][M];
double f[M][M][M][M][N];
double X;

double get(int x1, int y1, int x2, int y2) {
	double sum = pre[x2][y2] - pre[x2][y1 - 1] - pre[x1 - 1][y2] + pre[x1 - 1][y1 - 1] - X;
	return sum * sum / n;
}

double dp(int x1, int y1, int x2, int y2, int k) {
	double& v = f[x1][y1][x2][y2][k];
	if (v >= 0) return v;
	if (k == 1) return v = get(x1, y1, x2, y2);

	v = INF;
	for (int i = x1; i < x2; i++) {
		v = min(v, get(x1, y1, i, y2) + dp(i + 1, y1, x2, y2, k - 1));
		v = min(v, get(i + 1, y1, x2, y2) + dp(x1, y1, i, y2, k - 1));
	}
	for (int i = y1; i < y2; i++) {
		v = min(v, get(x1, y1, x2, i) + dp(x1, i + 1, x2, y2, k - 1));
		v = min(v, get(x1, i + 1, x2, y2) + dp(x1, y1, x2, i, k - 1));
	}

	return v;
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &pre[i][j]);
			pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
		}
	}
	X = (double)pre[m][m] / n;
	memset(f, -1, sizeof f);
	printf("%.3lf\n", sqrt(dp(1, 1, m, m, n)));
}
