package DP;

/**
 * @author Hyper
 * @date 2024/09/06
 * @file M3176_求出最长好子序列I.java
 * <p>
 * 思路
 * 一上来完全读不懂题，看样例更迷了。。。
 * 看评论才发现test case下面子序列的数，由下划线标出了
 * DP
 * 1. 状态表示
 * 集合：f[i][j]为以nums[i]结尾且有j个数满足与后一个元素不相等时，好子序列的最长长度
 * 属性：cnt
 * 2. 状态计算
 * f[i][j] = max(f[i][j], f[x][j] + 1, f[x][j - 1] + 1)
 * 枚举x
 * f[x][j] + 1: nums[i] == nums[x]
 * f[x][j - 1] + 1: nums[i] != nums[x] && j - 1 >= 0
 * k = 0 相当于找哪个数出现是最多的，ans为它们的数目之和
 */
public class M3176_求出最长好子序列I {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[n][k + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x < i; x++) {
                    if (nums[i] == nums[x]) {
                        f[i][j] = Math.max(f[i][j], f[x][j]);
                    } else if (j > 0) {
                        f[i][j] = Math.max(f[i][j], f[x][j - 1]);
                    }
                }
                f[i][j]++;
            }
            ans = Math.max(ans, f[i][k]);
        }

        return ans;
    }
}
