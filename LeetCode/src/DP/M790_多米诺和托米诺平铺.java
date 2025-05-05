package DP;

/**
 * @author Hyper
 * @date 2022/11/12，2025/05/05
 * @file M790_多米诺和托米诺平铺.java
 * <p>
 * 思路
 * 状态机
 * 1. 状态表示
 * 集合：f[i][j]表示铺到第i列、状态为j时，可行的方案数
 * i依次向右遍历，列举所有可能的状态：
 * j = 0 该列的上、下两格均未铺上
 * j = 1 该列的上格已铺上、下格未铺上
 * j = 2 该列的下格已铺上、上格未铺上
 * j = 3 该列的上、下两格均已铺上
 * 属性：cnt
 * 2. 状态计算
 * f[i][0] = f[i - 1][3];
 * f[i][1] = (f[i - 1][0] + f[i - 1][2]) % MOD;
 * f[i][2] = (f[i - 1][0] + f[i - 1][1]) % MOD;
 * f[i][3] = (((f[i - 1][0] + f[i - 1][1]) % MOD + f[i - 1][2]) % MOD + f[i - 1][3]) % MOD;
 */
public class M790_多米诺和托米诺平铺 {
    private final int MOD = (int) 1e9 + 7;

    public int numTilings(int n) {
        int[][] f = new int[n + 1][4];
        f[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][3];
            f[i][1] = (f[i - 1][0] + f[i - 1][2]) % MOD;
            f[i][2] = (f[i - 1][0] + f[i - 1][1]) % MOD;
            f[i][3] = (((f[i - 1][0] + f[i - 1][1]) % MOD + f[i - 1][2]) % MOD + f[i - 1][3]) % MOD;
        }

        return f[n][3];
    }
}
