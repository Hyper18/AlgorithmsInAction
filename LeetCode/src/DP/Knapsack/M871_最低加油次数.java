package DP.Knapsack;

/**
 * @author Hyperspace
 * @date 2024/10/07
 * @file M871_最低加油次数.java
 * <p>
 * 思路
 * 01背包
 * 从大到小遍历背包容量以优化空间
 * <p>
 * 注意爆int
 */
public class M871_最低加油次数 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] f = new long[n + 1];
        f[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (f[j] >= stations[i][0]) {
                    f[j + 1] = Math.max(f[j + 1], f[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (f[i] >= target) {
                return i;
            }
        }

        return -1;
    }
}
