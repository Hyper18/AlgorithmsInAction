package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/06/28
 * @file M2099_找到和最大的长度为K的子序列.java
 * <p>
 * 思路
 * 排序两次，先值后下标
 */
public class M2099_找到和最大的长度为K的子序列 {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = nums[i];
            idx[i][1] = i;
        }
        Arrays.sort(idx, (a, b) -> b[0] - a[0]);
        Arrays.sort(idx, 0, k, (a, b) -> a[1] - b[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = idx[i][0];
        }

        return res;
    }
}
