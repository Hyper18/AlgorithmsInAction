package Stack_Queue;

import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2023/10/18
 * @file M2530_执行K次操作后的最大分数.java
 * <p>
 * 思路
 * 优先队列
 */
public class M2530_执行K次操作后的最大分数 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            q.offer(n);
        }
        long ans = 0;
        while (k-- > 0) {
            int p = q.poll();
            ans += p;
            q.offer((p + 2) / 3);
        }

        return ans;
    }
}
