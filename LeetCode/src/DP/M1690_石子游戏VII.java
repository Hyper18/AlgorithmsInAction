package DP;

/**
 * @author Hyperspace
 * @date 2024/02/03
 * @file M1690_石子游戏VII.java
 * <p>
 * 思路
 * DP，前缀和
 * 1. 状态表示
 * 集合：f[l][r]表示stones中第l个到第r个区间，Alice与Bob得分的差值
 * 属性：max
 * 2. 状态计算
 * f[l][r] = max(pre[r] - pre[l] - f[l+1][r], pre[r-1] - pre[l-1] - f[l][r-1])
 * 对区间[l, r]：
 * 1）当前这一轮取l
 * Alice得分为此时的区间和pre[r] - pre[l]
 * Bob的最佳净得分相应为f[l+1][r]
 * 差值diff = pre[r] - pre[l] - f[l+1][r]
 * 2）当前这一轮取r
 * Alice得分为此时的区间和pre[r-1] - pre[l-1]
 * Bob的最佳净得分相应为f[l][r-1]
 * 差值diff = pre[r-1] - pre[l-1] - f[l][r-1]
 * <p>
 * 时间复杂度：O(n^2)
 */
public class M1690_石子游戏VII {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                f[l][r] = Math.max(pre[r] - pre[l] - f[l + 1][r], pre[r - 1] - pre[l - 1] - f[l][r - 1]);
            }
        }

        return f[1][n];
    }
}
