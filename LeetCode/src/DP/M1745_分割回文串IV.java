package DP;

/**
 * @author Hyper
 * @date 2025/03/04
 * @file M1745_分割回文串IV.java
 * <p>
 * 思路@灵茶山艾府
 * 1278的特例
 * DP
 */
public class M1745_分割回文串IV {
    private static final int INF = 0x3f3f3f3f;

    public boolean checkPartitioning(String s) {
        return palindromePartition(s, 3) == 0;
    }

    private int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] minChange = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                minChange[i][j] = minChange[i + 1][j - 1] + (s.charAt(i) != s.charAt(j) ? 1 : 0);
            }
        }
        int[] f = minChange[0];
        for (int i = 1; i < k; i++) {
            for (int r = n - k + i; r >= i; r--) {
                f[r] = INF;
                for (int l = i; l <= r; l++) {
                    f[r] = Math.min(f[r], f[l - 1] + minChange[l][r]);
                }
            }
        }

        return f[n - 1];
    }
}
