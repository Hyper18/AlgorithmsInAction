package SWM;

import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2023/02/28
 * @file Q239_滑动窗口最大值.java
 * <p>
 * 思路
 * 1. SWM (TLE)
 * 2. SWM + 优先队列，利用大根堆优化
 * 1) 如果值的大小不同，大的在上
 * 2) 如果值的大小相同，idx大的在上
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
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        res[0] = pq.peek()[1];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{i, nums[i]});
            while (pq.peek()[0] <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[1];
        }

        return res;
    }
}
