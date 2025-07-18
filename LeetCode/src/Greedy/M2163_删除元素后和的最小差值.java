package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2025/07/18
 * @file M2163_删除元素后和的最小差值.java
 * <p>
 * 思路
 * 贪心，前缀和+后缀和+最小堆+最大堆
 * 重点在于枚举中间[n, 2n)的下标分割位置
 */
public class M2163_删除元素后和的最小差值 {
    public long minimumDifference(int[] nums) {
        int m = nums.length, n = m / 3;
        PriorityQueue<Integer> qMin = new PriorityQueue<>(), qMax = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0, pre = 0;
        for (int i = m - 1; i >= m - n; i--) {
            qMin.offer(nums[i]);
            sum += nums[i];
        }
        long[] suf = new long[m - n + 1];
        suf[m - n] = sum;
        for (int i = m - n - 1; i >= n; i--) {
            int num = nums[i];
            if (num > qMin.peek()) {
                sum += num - qMin.poll();
                qMin.offer(num);
            }
            suf[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            qMax.offer(nums[i]);
            pre += nums[i];
        }
        long ans = pre - suf[n];
        for (int i = n; i < m - n; i++) {
            int num = nums[i];
            if (num < qMax.peek()) {
                pre += num - qMax.poll();
                qMax.offer(num);
            }
            ans = Math.min(ans, pre - suf[i + 1]);
        }

        return ans;
    }
}
