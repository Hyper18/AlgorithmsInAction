package DP;

/**
 * @author Hyper
 * @date 2025/01/19
 * @file M2266_统计打字方案数.java
 * <p>
 * 思路
 * DP
 */
public class M2266_统计打字方案数 {
    private final int MOD = (int) 1e9 + 7, N = (int) 1e5 + 10;
    private long[] f = new long[N + 3], g = new long[N + 4];

    public int countTexts(String pressedKeys) {
        char[] s = pressedKeys.toCharArray();
        int n = s.length;
        f[3] = g[4] = 1;
        for (int i = 1; i < N; i++) {
            f[i + 3] = (f[i + 2] + f[i + 1] + f[i]) % MOD;
            g[i + 4] = (g[i + 3] + g[i + 2] + g[i + 1] + g[i]) % MOD;
        }
        long ans = 1;
        for (int l = 0, r = 1; r <= n; r++) {
            char last = s[r - 1];
            if (r == n || s[r] != last) {
                int len = r - l;
                ans = (ans * (last == '7' || last == '9' ? g[len + 4] : f[len + 3])) % MOD;
                l = r;
            }
        }

        return (int) ans;
    }
}
