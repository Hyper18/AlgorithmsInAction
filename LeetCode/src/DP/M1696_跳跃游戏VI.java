package DP;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2024/02/05
 * @file M1696_跳跃游戏VI.java
 * <p>
 * 思路
 * 包含SWM的做法
 * 1) dp
 * 2) 空间优化
 */
public class M1696_跳跃游戏VI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] f = new int[n];
        f[0] = nums[0];
        q.offer(0);
        for (int i = 1; i < n; i++) {
            if (q.peek() < i - k) {
                q.poll();
            }
            f[i] = f[q.peek()] + nums[i];
            while (!q.isEmpty() && f[i] >= f[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
        }

        return f[n - 1];
    }

    public int maxResult2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 1; i < n; i++) {
            if (q.peek() < i - k) {
                q.poll();
            }
            nums[i] += nums[q.peek()];
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
        }

        return nums[n - 1];
    }
}
