package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/12/12
 * @file M2931_购买物品的最大开销.java
 * <p>
 * 思路
 * 1. 贪心
 * 将所有元素按照升序排列后依次取
 * 2. 优先队列
 * 存对应下标i, j
 */
public class M2931_购买物品的最大开销 {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        int[] nums = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(values[i], 0, nums, i * n, n);
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 1; i <= m * n; i++) {
            ans += (long) nums[i - 1] * i;
        }

        return ans;
    }

    public long maxSpending2(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> values[a[0]][a[1]]));
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i, n - 1});
        }
        long ans = 0;
        for (int idx = 1; idx <= m * n; idx++) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            ans += (long) values[i][j] * idx;
            if (j > 0) {
                q.offer(new int[]{i, j - 1});
            }
        }

        return ans;
    }
}
