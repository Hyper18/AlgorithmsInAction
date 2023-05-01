package DP;

/**
 * @author Hyperspace
 * @date 2023/04/19
 * @file M1043_分隔数组以得到最大和.java
 * <p>
 * 思路
 * dp，一开始看题干很像贪心
 */
public class M1043_分隔数组以得到最大和 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxVal = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                f[i] = Math.max(f[i], f[j] + maxVal * (i - j));
                if (j > 0) {
                    maxVal = Math.max(maxVal, arr[j - 1]);
                }
            }
        }

        return f[n];
    }
}
