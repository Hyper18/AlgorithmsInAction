package DP;

/**
 * @author Hyper
 * @date 2025/04/01
 * @file M2140_解决智力问题.java
 * <p>
 * 思路
 * 打家劫舍变体
 * 由于限制条件跟当前的状态是绑定的
 * 考虑转移方程向后续状态转
 * 即递推方向为从左至右
 */
public class M2140_解决智力问题 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = Math.max(f[i + 1], f[i]);
            int j = Math.min(i + questions[i][1] + 1, n);
            f[j] = Math.max(f[j], f[i] + questions[i][0]);
        }

        return f[n];
    }
}
