package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/07/21
 * @file M1186_删除一次得到子数组最大和.java
 * <p>
 * 思路
 * 1. DP状态机
 * 1) 未删除
 * 2) 已删除
 * 2. 贪心（弃）
 * 当当前元素不小于0时 累计sum
 * 小于0时
 * 1) 第一次遇到 记录flag
 * 2) 第二次遇到 记录这一段的和
 */
public class M1186_删除一次得到子数组最大和 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int[][] f = new int[n + 1][2];
        Arrays.fill(f[0], -0x3f);
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], 0) + arr[i];
            f[i + 1][1] = Math.max(f[i][1] + arr[i], f[i][0]);
            ans = Math.max(ans, Math.max(f[i + 1][0], f[i + 1][1]));
        }

        return ans;
    }

    public int maximumSum2(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int i = 0, neg = 0, ans = Integer.MIN_VALUE, sum = 0;
        boolean flag = false;
        while (i < n) {
            int t = arr[i];
            if (t >= 0) {
                sum += t;
            } else {
                if (!flag) {
                    flag = true;
                    neg = t;
                } else {
                    if (sum == 0) {
                        ans = Math.max(ans, Math.max(neg, t));
                    } else {
                        ans = Math.max(ans, sum);
                        sum = 0;
                    }
                    while (i + 1 < n && arr[i + 1] < 0) {
                        i++;
                    }
                    flag = false;
                }
            }
            i++;
        }

        return ans > 0 || ans == Integer.MIN_VALUE || flag ? Math.max(ans, sum) : ans;
    }
}
