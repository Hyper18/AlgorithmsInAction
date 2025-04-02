package Greedy;

/**
 * @author Hyperspace
 * @date 2025/04/02
 * @file M2873_有序三元组中的最大值I.java
 * <p>
 * 思路
 * 1. 模拟 -- 时间 O(n^3)，空间 O(1)
 * 2. 枚举j，前缀和+贪心 -- 时间 O(n)，空间 O(n)
 * 3. 枚举k，贪心 -- 时间 O(n)，空间 O(1)
 */
public class M2873_有序三元组中的最大值I {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return ans;
    }

    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n], suf = new int[n];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i - 1]);
            suf[n - 1 - i] = Math.max(suf[n - i], nums[n - i]);
        }
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (long) (pre[i] - nums[i]) * suf[i]);
        }

        return ans;
    }

    public long maximumTripletValue3(int[] nums) {
        long ans = 0, diff = 0, pre = 0;
        for (int num : nums) {
            ans = Math.max(ans, diff * num);
            diff = Math.max(diff, pre - num);
            pre = Math.max(pre, num);
        }

        return ans;
    }
}
