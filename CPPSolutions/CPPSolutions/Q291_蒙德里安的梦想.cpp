/**
 * 思路
 * 1. 状态表示
 * 集合：f[i][j]表示铺到第i列、状态为j时，可行的方案数
 * 转化为考虑所有横向方块的位置摆放
 * i-1, i列已经固定，所以集合划分是依据i-2 列伸到 i-1 列的不同状态 k 来划分
 * 属性：cnt
 * 2. 状态计算
 * f[i][j] += f[i - 1][k]
 */

#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

const int N = 12, M = 1 << N;

typedef long long LL;

int n, m;
LL f[N][M];
bool st[M];

int main() {
	while (cin >> n >> m, n || m) {
		for (int i = 0; i < 1 << n; i++) {
			int cnt = 0;
			st[i] = true;
			for (int j = 0; j < n; j++) {
				if (i >> j & 1) {
					if (cnt & 1) st[i] = false;
					cnt = 0;
				}
				else cnt++;
			}
			if (cnt & 1) st[i] = false;
		}

		memset(f, 0, sizeof f);
		f[0][0] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < 1 << n; j++) {
				for (int k = 0; k < 1 << n; k++) {
					if ((j & k) == 0 && st[j | k])
						f[i][j] += f[i - 1][k];
				}
			}
		}

		cout << f[m][0] << endl;
	}

	return 0;
}