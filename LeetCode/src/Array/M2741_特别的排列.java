package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/06/26
 * @file M2741_特别的排列.java
 * <p>
 * 思路 @灵茶山艾府
 * 第一下想法是回溯，列举所有可能的排列
 * 状压DP求方案数 + 位运算
 * 枚举当前要选的数的下标 j
 * dfs(S,i) 表示在可以选的下标集合为 S，上一个选的数的下标是 i 时，可以构造出多少个特别排列
 * <p>
 * 待回看
 * 注意爆int
 */
public class M2741_特别的排列 {
    private final int MOD = (int) 1e9 + 7;

    public int specialPerm(int[] nums) {
        int n = nums.length;
        int u = (1 << n) - 1;
        long[][] memo = new long[u][n];
        for (long[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(u ^ (1 << i), i, nums, memo);
        }
        return (int) (ans % MOD);
    }

    private long dfs(int s, int i, int[] nums, long[][] memo) {
        if (s == 0) {
            return 1;
        }
        if (memo[s][i] != -1) {
            return memo[s][i];
        }
        long res = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((s >> j & 1) > 0 && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                res += dfs(s ^ (1 << j), j, nums, memo);
            }
        }

        return memo[s][i] = res;
    }
}
