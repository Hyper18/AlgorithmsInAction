package SWM;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/03/04
 * @file Q1438_绝对差不超过限制的最长连续子数组.java
 * <p>
 * 思路
 * 1. SWM，维护两个优先队列
 * PriorityQueue.remove()可直接删除对应值的元素
 * 2. SWM，维护两个单调队列
 */
public class Q1438_绝对差不超过限制的最长连续子数组 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        PriorityQueue<Integer> qMin = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> qMax = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            int rn = nums[r], ln = nums[l];
            qMin.add(rn);
            qMax.add(rn);
            if (qMax.peek() - qMin.peek() <= limit) {
                ans = Math.max(ans, r - l + 1);
            } else {
                qMin.remove(ln);
                qMax.remove(ln);
                l++;
            }
            r++;
        }

        return ans;
    }

    public int longestSubarray2(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> qMin = new ArrayDeque<>(), qMax = new ArrayDeque<>();
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            while (!qMin.isEmpty() && qMin.peekLast() > nums[r]) {
                qMin.pollLast();
            }
            while (!qMax.isEmpty() && qMax.peekLast() < nums[r]) {
                qMax.pollLast();
            }
            qMin.offerLast(nums[r]);
            qMax.offerLast(nums[r]);
            while (!qMin.isEmpty() && !qMax.isEmpty() && qMax.peekFirst() - qMin.peekFirst() > limit) {
                if (nums[l] == qMin.peekFirst()) {
                    qMin.pollFirst();
                }
                if (nums[l] == qMax.peekFirst()) {
                    qMax.pollFirst();
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
