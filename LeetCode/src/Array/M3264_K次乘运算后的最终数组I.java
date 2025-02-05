package Array;

import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/12/13
 * @file M3264_K次乘运算后的最终数组I.java
 * <p>
 * 思路
 * 模拟，最小堆
 */
public class M3264_K次乘运算后的最终数组I {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] p = q.poll();
            p[0] *= multiplier;
            q.offer(p);
        }
        int[] res = new int[n];
        while (!q.isEmpty()) {
            int[] p = q.poll();
            res[p[1]] = p[0];
        }

        return res;
    }
}
