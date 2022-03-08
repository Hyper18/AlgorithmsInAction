package DP;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * <p>
 * dp -- O(mn)
 */
public class Q64_最小路径和 {
    private int[][] dp;
    int m, n;

    private void init(int[][] grid) {
        dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
    }

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        init(grid);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] + grid[i][j] : dp[i][j - 1] + +grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
