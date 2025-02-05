package DP.Knapsack;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/06/28
 * @file M2742_给墙壁刷油漆.java
 * <p>
 * 思路
 * 01背包
 * 对应背包体积为时间，求最大价值为n堵墙的开销
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 * <p>
 * 注意这里数组初始化不要给MAX_VALUE，加法会溢出
 */
public class M2742_给墙壁刷油漆 {
    final int MAX = 0x3f3f3f3f;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, MAX);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i], t = time[i] + 1;
            for (int j = n; j > 0; j--) {
                f[j] = Math.min(f[j], f[Math.max(j - t, 0)] + c);
            }
        }

        return f[n];
    }
}
