package Array;

/**
 * @author Hyperspace
 * @date 2024/09/10
 * @file M2552_统计上升四元组.java
 * <p>
 * 思路
 * 两层枚举
 * <p>
 * pre[x]: nums[0] 到 nums[j−1]中小于x的元素个数
 */
public class M2552_统计上升四元组 {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        long ans = 0;
        for (int j = 0; j < n; j++) {
            int suf = 0;
            for (int k = n - 1; k > j; k--) {
                if (nums[j] > nums[k]) {
                    ans += (long) pre[nums[k]] * suf;
                } else {
                    suf++;
                }
            }
            for (int x = nums[j] + 1; x <= n; x++) {
                pre[x]++;
            }
        }

        return ans;
    }
}
