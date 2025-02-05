package DP.Knapsack;

/**
 * @author Hyper
 * @date 2022/03/19
 * 这题相对比较好理解
 * 将原问题转化为二维背包问题
 * “m 个 0 和 n 个 1” -- 背包的容量恰为 m（容纳0） n（容纳1）
 * 01背包可以直接状压，使用一个二维数组表示
 * <p>
 * 为了提高操作速度，使用一个int数组计数而非hash
 */
public class Q474_一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= N; i++) {
            int[] cnt = count(strs[i - 1]);
            for (int j = m; j >= cnt[0]; j--) {
                for (int k = n; k >= cnt[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - cnt[0]][k - cnt[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private static int[] count(String str) {
        int[] cnt = new int[2];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - '0']++;
        }
        return cnt;
    }
}
