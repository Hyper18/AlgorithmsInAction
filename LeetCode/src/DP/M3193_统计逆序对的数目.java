package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/10/17
 * @file M3193_统计逆序对的数目.java
 * <p>
 * 思路@灵茶山艾府
 * 从数据量看，可以用记忆化的dfs，也可以使用DP
 * req[i]：perm[0] 到 perm[i] 的逆序对个数
 * 分类讨论：
 * 1. j<req[i−1] dfs(i, j) = 0
 * 2. j−i>req[i−1] dfs(i, j) = 0
 * <p>
 * 特判case 718：if req[0] > 0 then return 0
 * <p>
 * DP
 * 1. 状态表示
 * 集合：f[i][j]表示在下标区间[0,i]中，符合条件的排列数目
 * 属性：cnt
 * 2. 状态计算
 * f[i][j] += f[i - 1][j - k]
 * k为左侧的逆序对数目
 * <p>
 * 题干比较晦涩
 * 对于每个requirements[i] = [end_i, cnt_i]
 * 表示在下标区间[0,end_i]中，共有cnt_i个逆序数对
 * 即包含cnt_i个i < j且nums[i] > nums[j]的数对
 */
public class M3193_统计逆序对的数目 {
    private final int MOD = (int) (1e9 + 7);
    private int[] req;
    private int[][] memo;

    public int numberOfPermutations(int n, int[][] requirements) {
        req = new int[n];
        Arrays.fill(req, -1);
        req[0] = 0;
        int m = 0;
        for (int[] p : requirements) {
            req[p[0]] = p[1];
            m = Math.max(m, p[1]);
        }
        if (req[0] > 0) {
            return 0;
        }
        memo = new int[n][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(n - 1, req[n - 1]);
    }

    private int dfs(int i, int j) {
        if (i == 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = 0, r = req[i - 1];
        if (r < 0) {
            for (int k = 0; k <= Math.min(i, j); k++) {
                ans = (ans + dfs(i - 1, j - k)) % MOD;
            }
        } else {
            if (j >= r && j - i <= r) {
                ans = dfs(i - 1, r);
            }
        }

        return memo[i][j] = ans;
    }
}
