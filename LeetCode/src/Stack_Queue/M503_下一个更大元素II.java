package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2024/06/24
 * @file M503_下一个更大元素II.java
 * <p>
 * 思路
 * 模拟，单调栈
 */
public class M503_下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < (n << 1); i++) {
            int idx = i >= n ? i - n : i;
            while (!q.isEmpty() && nums[q.peekLast()] < nums[idx]) {
                res[q.pollLast()] = nums[idx];
            }
            q.offer(idx);
        }

        return res;
    }
}
