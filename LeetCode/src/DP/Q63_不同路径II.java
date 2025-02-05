package DP;

/**
 * @author Hyper
 * @date 2024/09/23
 * @file Q63_不同路径II.java
 * <p>
 * 思路
 * DP
 * 1. 状态表示
 * 集合：f[i][j]为从(0, 0)到达(i, j)的所有可行路径数目
 * 属性：cnt
 * 2. 状态计算
 * 分类讨论：
 * 1) 无障碍物时
 * 只能从向下走和向右走两种状态转移得到
 * f[i][j] = f[i - 1][j] + f[i][j - 1]
 * 2) 有障碍物时
 * f[i][j] = 0
 * <p>
 * 注：
 * 特判test case: obstacleGrid[0][0] == 1
 * f[0][0] = check(obstacleGrid, 0, 0) ? 0 : 1
 */
public class Q63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = check(obstacleGrid, 0, 0) ? 0 : 1;
        for (int j = 1; j < n; j++) {
            f[0][j] = check(obstacleGrid, 0, j) ? 0 : f[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            f[i][0] = check(obstacleGrid, i, 0) ? 0 : f[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (check(obstacleGrid, i, j)) {
                    f[i][j] = 0;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }

    private boolean check(int[][] a, int i, int j) {
        return a[i][j] == 1;
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    f[i][j] = 1;
                } else if (i == 0) {
                    f[i][j] = f[0][j - 1];
                } else if (j == 0) {
                    f[i][j] = f[i - 1][0];
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int[] obs : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (obs[j] == 1) {
                    f[j] = 0;
                } else if (j - 1 >= 0 && obs[j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[n - 1];
    }
}
