package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/12/10
 * @file M935_骑士拨号器.java
 * <p>
 * 思路
 * DP状态机
 */
public class M935_骑士拨号器 {
    private final int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        long[] f = new long[10];
        Arrays.fill(f, 1);
        while (--n > 0) {
            long[] t = new long[10];
            t[0] = (f[4] + f[6]) % MOD;
            t[1] = (f[6] + f[8]) % MOD;
            t[2] = (f[7] + f[9]) % MOD;
            t[3] = (f[4] + f[8]) % MOD;
            t[4] = (f[0] + f[3] + f[9]) % MOD;
            t[6] = (f[0] + f[1] + f[7]) % MOD;
            t[7] = (f[2] + f[6]) % MOD;
            t[8] = (f[1] + f[3]) % MOD;
            t[9] = (f[2] + f[4]) % MOD;
            f = t;
        }

        return (int) (Arrays.stream(f).sum() % MOD);
    }
}
