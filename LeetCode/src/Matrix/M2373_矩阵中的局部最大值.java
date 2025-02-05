package Matrix;

/**
 * @author Hyper
 * @date 2023/03/02
 * @file M2373_矩阵中的局部最大值.java
 * <p>
 * 思路
 * 模拟，小数据量
 */
public class M2373_矩阵中的局部最大值 {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length - 2, n = grid[0].length - 2;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ans = grid[i][j];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (grid[k][l] > ans) {
                            ans = grid[k][l];
                        }
                    }
                }
                res[i][j] = ans;
            }
        }

        return res;
    }
}
