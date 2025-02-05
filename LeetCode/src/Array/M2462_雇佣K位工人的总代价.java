package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/05/01
 * @file M2462_雇佣K位工人的总代价.java
 * <p>
 * 思路
 * 模拟
 * 分类讨论：
 * 1）要求的首尾长度相加大于数组长度 candidates > (n >> 1)
 * 这部分子问题就比较简单
 * 即转化为贪心问题，直接对数组升序排序，每次依次取最小值
 * 2）要求的首尾长度相加不大于数组长度
 * 转化为双指针
 * 依次处理首尾两部分，每次取两部分中较小的cost
 * 最后若l > r但还需要选取
 * 则合并首尾，处理方式跟1类似
 */
public class M2462_雇佣K位工人的总代价 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (candidates > (n >> 1)) {
            Arrays.sort(costs);
            int i = 0;
            while (i < k) {
                ans += costs[i++];
            }
            return ans;
        }
        PriorityQueue<Integer> front = new PriorityQueue<>(), end = new PriorityQueue<>();
        int l = 0, r = n - 1;
        while (l < candidates) {
            front.offer(costs[l++]);
            end.offer(costs[r--]);
        }
        while (l <= r && k > 0) {
            if (front.peek() <= end.peek()) {
                ans += front.poll();
                front.offer(costs[l++]);
            } else {
                ans += end.poll();
                end.offer(costs[r--]);
            }
            k--;
        }
        if (k > 0) {
            front.addAll(end);
            while (k-- > 0) {
                ans += front.poll();
            }
        }

        return ans;
    }
}
