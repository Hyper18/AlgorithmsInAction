package DP;

/**
 * @author Hyperspace
 * @date 2022/10/14
 * <p>
 * 思路
 * DP
 * 1. 状态表示
 * 集合：f[i][j]表示nums1到第i位和nums2到第j位（从右往左）时的最长公共前缀的长度
 * 属性：Max
 * 2. 状态计算
 * 分类讨论：
 * 1) nums1[i] == nums2[j]
 * f[i][j] = f[i + 1][j + 1] + 1
 * 2) nums1[i] != nums2[j]
 * f[i][j] = 0
 */
public class Q718_最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] f = new int[n1 + 1][n2 + 1];
        int ans = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    f[i][j] = f[i + 1][j + 1] + 1;
                }
                ans = Math.max(ans, f[i][j]);
            }
        }

        return ans;
    }
}
