package Array;

import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2025/01/14
 * @file M3066_超过阈值的最少操作数II.java
 * <p>
 * 思路
 * 最小堆
 */
public class M3066_超过阈值的最少操作数II {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer((long) num);
        }
        int ans = 0;
        while (q.peek() < k) {
            q.offer(q.poll() * 2 + q.poll());
            ans++;
        }

        return ans;
    }
}
