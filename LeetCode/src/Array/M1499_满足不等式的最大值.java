package Array;

import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2023/07/21
 * @file M1499_满足不等式的最大值.java
 * <p>
 * 思路
 * 大根堆
 * yi + yj + ∣xi − xj∣ = yi + yj + xj - xi = -xi + yi + xj + yj
 */
public class M1499_满足不等式的最大值 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] pos : points) {
            int x = pos[0], y = pos[1];
            while (!q.isEmpty() && x - q.peek()[1] > k) {
                q.poll();
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, x + y + q.peek()[0]);
            }
            q.offer(new int[]{y - x, x});
        }

        return ans;
    }
}
