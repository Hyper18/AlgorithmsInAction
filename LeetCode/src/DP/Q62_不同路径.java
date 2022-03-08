package DP;

/**
 * @author Hyperspace
 * @date 2022/03/08
 */
public class Q62_不同路径 {
    private int[][] dp;

    private void init(int m, int n) {
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
    }

    public int uniquePaths(int m, int n) {
        init(m, n);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
