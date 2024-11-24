package Array;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/11/24
 * @file M632_最小区间.java
 * <p>
 * 思路@灵茶山艾府
 * 排序+最小堆
 * 先将每个列表的第一个元素入堆，再更新合法区间的左右端点
 */
public class M632_最小区间 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums.get(i).get(0);
            q.offer(new int[]{x, i, 0});
            r = Math.max(r, x);
        }
        int[] res = new int[]{q.peek()[0], r};
        while (q.peek()[2] + 1 < nums.get(q.peek()[1]).size()) {
            int[] p = q.poll();
            p[0] = nums.get(p[1]).get(++p[2]);
            r = Math.max(r, p[0]);
            q.offer(p);
            int l = q.peek()[0];
            if (r - l < res[1] - res[0]) {
                res = new int[]{l, r};
            }
        }

        return res;
    }
}
