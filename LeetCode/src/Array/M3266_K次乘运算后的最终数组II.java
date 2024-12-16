package Array;

import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/12/14
 * @file M3266_K次乘运算后的最终数组II.java
 * <p>
 * 思路
 * 最小堆+快速幂
 * 模拟直到mx成为前n个数的最小值
 * <p>
 * 注意快速幂qmi()入参base为long
 * 还有TC671会卡multiplier=1的情况
 */
public class M3266_K次乘运算后的最终数组II {
    private final int MOD = (int) (1e9 + 7);

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        int n = nums.length;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            q.offer(new long[]{nums[i], i});
        }
        for (; k > 0 && q.peek()[0] < mx; k--) {
            long[] p = q.poll();
            p[0] *= multiplier;
            q.offer(p);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long[] p = q.poll();
            res[(int) p[1]] = (int) (p[0] % MOD * qmi(multiplier, k / n + (i < k % n ? 1 : 0)) % MOD);
        }

        return res;
    }

    private long qmi(long a, int k) {
        long ans = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            k >>= 1;
        }

        return ans;
    }
}
