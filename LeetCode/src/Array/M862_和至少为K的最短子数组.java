package Array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2022/10/26
 * <p>
 * 思路
 * 模拟，但只可解决无负数情况
 * <p>
 * 这样需要使用前缀和记录到每位时的sum
 * 记录下标，一次遍历
 * 当sum>=k时，判断
 * <p>
 * 注：数据量会爆int
 */
public class M862_和至少为K的最短子数组 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int len = 1, sum = nums[i];
            for (int j = i + 1; j < n && sum < k; j++) {
                sum += nums[j];
                len++;
            }
            if (sum == k) {
                ans = Math.min(ans, len);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int shortestSubarray2(int[] nums, int k) {
        int n = nums.length;
        // 维护long数组记录前缀和
        long[] preSum = new long[n + 10];
        // preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Deque<Integer> q = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        // 前缀和下标0~n
        for (int i = 0; i <= n; i++) {
            while (!q.isEmpty() && preSum[i] - preSum[q.peekFirst()] >= k) {
                ans = Math.min(ans, i - q.pollFirst());
            }
            while (!q.isEmpty() && preSum[q.peekLast()] >= preSum[i]) {
                q.pollLast();
            }
            q.offer(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
