package TwoPointer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2024/09/13
 * @file M2398_预算内的最多机器人数目.java
 * <p>
 * 思路
 * 1. 前缀和+双指针
 * 由题干知不可排序
 * 将题目转换为连续子数组考虑
 * 2. 双指针优化
 * <p>
 * review：
 * queue的FIFO对应队首在索引小处，故：
 * peek() = peekFirst()
 * poll() = pollFirst()
 * offer() = offerLast() = addLast() = add()
 */
public class M2398_预算内的最多机器人数目 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> q = new ArrayDeque<>();
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + runningCosts[i - 1];
        }
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            while (!q.isEmpty() && chargeTimes[r] >= chargeTimes[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(r);
            while (!q.isEmpty() && chargeTimes[q.peek()] + (r - l + 1) * (pre[r + 1] - pre[l]) > budget) {
                if (l == q.peek()) {
                    q.poll();
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }

    public int maximumRobots2(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> q = new ArrayDeque<>();
        long sum = 0;
        int ans = 0, l = 0, r = 0;
        while (r < n) {
            while (!q.isEmpty() && chargeTimes[r] >= chargeTimes[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(r);
            sum += runningCosts[r];
            while (!q.isEmpty() && chargeTimes[q.peek()] + (r - l + 1) * sum > budget) {
                if (l == q.peek()) {
                    q.poll();
                }
                sum -= runningCosts[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
