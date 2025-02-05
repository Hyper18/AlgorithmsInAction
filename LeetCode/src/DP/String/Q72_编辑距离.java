package DP.String;

/**
 * @author Hyper
 * @date 2022/03/08
 */
public class Q72_编辑距离 {
    private int[][] dp;
    int len1, len2;

    private void init() {
        int size1 = len1 + 1;
        int size2 = len2 + 1;
        dp = new int[size1][size2];
        for (int i = 1; i < size1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j < size2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
    }

    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();
        init();

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
