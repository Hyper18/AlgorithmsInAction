package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/07/04
 * @file M3086_拾起K个1需要的最少行动次数.java
 * <p>
 * 思路
 * 中位数贪心
 * <p>
 * 待回看
 * 需要先看一下这类题型
 */
public class M3086_拾起K个1需要的最少行动次数 {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        List<Integer> pos = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            pos.add(i);
            c = Math.max(c, 1);
            if (i > 0 && nums[i - 1] == 1) {
                if (i > 1 && nums[i - 2] == 1) {
                    c = 3;
                } else {
                    c = Math.max(c, 2);
                }
            }
        }
        c = Math.min(c, k);
        if (maxChanges >= k - c) {
            return Math.max(c - 1, 0) + (k - c) * 2L;
        }
        int n = pos.size();
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + pos.get(i);
        }
        long ans = Long.MAX_VALUE;
        int size = k - maxChanges;
        for (int right = size; right <= n; right++) {
            int left = right - size;
            int i = left + size / 2;
            long index = pos.get(i);
            long s1 = index * (i - left) - (sum[i] - sum[left]);
            long s2 = sum[right] - sum[i] - index * (right - i);
            ans = Math.min(ans, s1 + s2);
        }

        return ans + maxChanges * 2L;
    }
}
