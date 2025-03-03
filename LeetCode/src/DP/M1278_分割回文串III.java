package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/03/03
 * @file M1278_分割回文串III.java
 * <p>
 * 思路
 * DP
 */
public class M1278_分割回文串III {
    private static final int INF = 0x3f3f3f3f;

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] f = new int[n + 1][k + 1];
        for (int[] row : f) {
            Arrays.fill(row, INF);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i][1] = check(s.substring(0, i));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int l = j - 1; l < i; l++) {
                    f[i][j] = Math.min(f[i][j], f[l][j - 1] + check(s.substring(l, i)));
                }
            }
        }

        return f[n][k];
    }

    private int check(String s) {
        int cnt = 0;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) == s.charAt(r--)) {
                continue;
            }
            cnt++;
        }

        return cnt;
    }
}
