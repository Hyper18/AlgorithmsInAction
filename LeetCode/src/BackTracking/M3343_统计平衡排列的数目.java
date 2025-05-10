package BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/05/09
 * @file M3343_统计平衡排列的数目.java
 * <p>
 * 思路
 * 1. 回溯，全排列
 * 487/792 TLE
 * 2. 记忆化 + 组合数学@灵茶山艾府
 * <p>
 * 待回看
 */
public class M3343_统计平衡排列的数目 {
    class Solution {
        private final int MOD = (int) 1e9 + 7;
        private Set<String> path = new HashSet<>();
        private char[] s;

        public int countBalancedPermutations(String num) {
            s = num.toCharArray();
            backtrack(0, 0, true);

            return path.size();
        }

        private void backtrack(int i, int diff, boolean isOdd) {
            if (i == s.length) {
                if (diff == 0) {
                    StringBuilder sb = new StringBuilder();
                    for (char c : s) {
                        sb.append(c);
                    }
                    path.add(sb.toString());
                }
                return;
            }
            for (int j = i; j < s.length; j++) {
                swap(i, j);
                backtrack(i + 1, (diff + (isOdd ? s[i] - '0' : -(s[i] - '0'))) % MOD, !isOdd);
                swap(i, j);
            }
        }

        private void swap(int i, int j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    class Solution2 {
        private final int MOD = (int) 1e9 + 7, N = 41;
        private final long[] f = new long[N]; // f[i] = i!
        private final long[] fInv = new long[N]; // inv_f[i] = i!^-1

        public int countBalancedPermutations(String num) {
            f[0] = 1;
            for (int i = 1; i < N; i++) {
                f[i] = f[i - 1] * i % MOD;
            }
            fInv[N - 1] = pow(f[N - 1], MOD - 2);
            for (int i = N - 1; i > 0; i--) {
                fInv[i - 1] = fInv[i] * i % MOD;
            }
            int[] cnt = new int[10];
            int total = 0;
            for (char c : num.toCharArray()) {
                cnt[c - '0']++;
                total += c - '0';
            }
            if (total % 2 > 0) {
                return 0;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            int n = num.length(), n1 = n / 2;
            int[][][] memo = new int[10][n1 + 1][total / 2 + 1];
            for (int[][] mat : memo) {
                for (int[] row : mat) {
                    Arrays.fill(row, -1);
                }
            }

            return (int) (f[n1] * f[n - n1] % MOD * dfs(9, n1, total / 2, cnt, memo) % MOD);
        }

        private int dfs(int i, int left1, int leftS, int[] cnt, int[][][] memo) {
            if (i < 0) {
                return leftS == 0 ? 1 : 0;
            }
            if (memo[i][left1][leftS] != -1) {
                return memo[i][left1][leftS];
            }
            long res = 0;
            int c = cnt[i] - (i > 0 ? cnt[i - 1] : 0);
            int left2 = cnt[i] - left1;
            for (int k = Math.max(c - left2, 0); k <= Math.min(c, left1) && k * i <= leftS; k++) {
                long r = dfs(i - 1, left1 - k, leftS - k * i, cnt, memo);
                res = (res + r * fInv[k] % MOD * fInv[c - k]) % MOD;
            }
            return memo[i][left1][leftS] = (int) res;
        }

        private long pow(long x, int n) {
            long res = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 > 0) {
                    res = res * x % MOD;
                }
                x = x * x % MOD;
            }
            return res;
        }
    }
}
