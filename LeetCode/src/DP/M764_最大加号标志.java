package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/11/09
 * <p>
 * 思路
 * 遍历，前缀和
 * 对每一个坐标
 * 枚举四个方向上连续为1的格子数目
 */
public class M764_最大加号标志 {
    final int N = 510;
    int[][] g = new int[N][N];
    int[][] u = new int[N][N], d = new int[N][N], l = new int[N][N], r = new int[N][N];

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], 1);
        }
        for (int[] pos : mines) {
            int x = pos[0], y = pos[1];
            g[x + 1][y + 1] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    u[i][j] = u[i - 1][j] + 1;
                    l[i][j] = l[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    d[n + 1 - i][n + 1 - j] = d[n + 2 - i][n + 1 - j] + 1;
                    r[n + 1 - i][n + 1 - j] = r[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(u[i][j], d[i][j]), Math.min(l[i][j], r[i][j])));
            }
        }

        return ans;
    }
}
