package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/03/16
 * @file M2488_统计中位数为K的子数组.java
 * <p>
 * 思路
 * 转化原问题求中位数为K的子数组个数为
 * 求满足中位数为k，且大于k的元素个数-小于k的元素个数<=1的子数组个数
 * 利用前缀和，则[j, i]为pre[i] - pre[j - 1]
 * 遍历数组
 * 1）当前值 == k 记为0
 * 2）当前值 > k 记为1
 * 3）当前值 < k 记为-1
 * 题目再次转化为求连续子数组和等于0的子数组个数（至少包含一个0，即上述情况1）
 * 因此用hash维护本次k前到上一个k的每个前缀和出现的次数，并移动左侧位置last
 * 累加取出的结果，包括此时的子数组长度为偶数和为奇数的情况
 * ans = ans + cnt(pre[i] - 1) + cnt(pre[i])
 */
public class M2488_统计中位数为K的子数组 {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0, last = 0;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            pre[i] = pre[i - 1] + Integer.compare(t, k);
            if (t == k) {
                for (int j = last; j < i; j++) {
                    mp.put(pre[j], mp.getOrDefault(pre[j], 0) + 1);
                }
                last = i;
            }
            ans += mp.getOrDefault(pre[i] - 1, 0) + mp.getOrDefault(pre[i], 0);
        }

        return ans;
    }
}
