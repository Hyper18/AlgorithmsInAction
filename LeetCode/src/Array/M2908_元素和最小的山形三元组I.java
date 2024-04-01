package Array;

/**
 * @author Hyperspace
 * @date 2024/03/29
 * @file M2908_元素和最小的山形三元组I.java
 * <p>
 * 思路
 * 1. O(n^2) 模拟
 * 2. O(n) 维护一个数组，存储山峰右侧的最小值
 * 由于向右不断遍历，左侧只需要一个最新的最小值
 */
public class M2908_元素和最小的山形三元组I {
    final int MAX = Integer.MAX_VALUE;

    public int minimumSum(int[] nums) {
        int n = nums.length;
        int ans = MAX;
        for (int i = 1, l, r; i < n - 1; i++) {
            int lMin = MAX, peek = nums[i], rMin = MAX;
            for (l = 0; l < i; l++) {
                lMin = Math.min(lMin, nums[l]);
            }
            for (r = i + 1; r < n; r++) {
                rMin = Math.min(rMin, nums[r]);
            }
            if (lMin < peek && rMin < peek) {
                ans = Math.min(ans, lMin + peek + rMin);
            }
        }

        return ans == MAX ? -1 : ans;
    }

    public int minimumSum2(int[] nums) {
        int n = nums.length;
        int[] rMin = new int[n];
        rMin[n - 1] = nums[n - 1];
        for (int r = n - 2; r > 1; r--) {
            rMin[r] = Math.min(rMin[r + 1], nums[r]);
        }
        int lMin = nums[0], ans = MAX;
        for (int i = 1; i < n - 1; i++) {
            int peek = nums[i];
            if (lMin < peek && rMin[i + 1] < peek) {
                ans = Math.min(ans, lMin + peek + rMin[i + 1]);
            }
            lMin = Math.min(lMin, peek);
        }

        return ans == MAX ? -1 : ans;
    }
}
