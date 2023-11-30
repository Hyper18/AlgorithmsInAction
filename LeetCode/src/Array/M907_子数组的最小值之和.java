package Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2023/11/27
 * @file M907_子数组的最小值之和.java
 * <p>
 * 思路
 * 在Q828的基础上使用单调栈
 * 注意弹栈和peek都是找最后一个元素
 */
public class M907_子数组的最小值之和 {
    final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) {
                r[q.pollLast()] = i;
            }
            q.offer(i);
        }
        q.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!q.isEmpty() && arr[q.peekLast()] > arr[i]) {
                l[q.pollLast()] = i;
            }
            q.offer(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = i - l[i], b = r[i] - i;
            ans += (long) a * b % MOD * arr[i] % MOD;
            ans %= MOD;
        }

        return ans;
    }
}
