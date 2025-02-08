package SWM;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/02/28，2025/02/08
 * @file Q239_滑动窗口最大值.java
 * <p>
 * 思路
 * 1. SWM -- TLE
 * 2. SWM+大根堆
 * 1) 值相同，下标大的在上
 * 2) 值不同，数值大的在上
 * 3. SWM+单调队列
 */
public class Q239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return new int[]{nums[0]};
        }
        int[] res = new int[n - k + 1];
        for (int l = 0, r = l + 1; l < n && r < n; l++) {
            r = l + 1;
            int t = nums[l];
            while (r < l + k) {
                t = Math.max(t, nums[r++]);
            }
            res[l] = t;
        }

        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            q.offer(new int[]{i, nums[i]});
        }
        res[0] = q.peek()[1];
        for (int i = k; i < n; i++) {
            q.offer(new int[]{i, nums[i]});
            while (q.peek()[0] <= i - k) {
                q.poll();
            }
            res[i - k + 1] = q.peek()[1];
        }

        return res;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.removeLast();
            }
            q.offer(i);
        }
        res[0] = nums[q.peekFirst()];
        for (int i = k; i < n; i++) {
            if (q.peekFirst() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.offer(i);
            res[i - k + 1] = nums[q.peekFirst()];
        }

        return res;
    }
}
