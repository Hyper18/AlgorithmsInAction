package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Hyperspace
 * @date 2023/06/28
 * @file M1681_最小不兼容性.java
 * <p>
 * 思路
 * 官解，状压dp
 * 主要的难点在于状态的定义，状态如何存储
 * 1. 状态表示
 * 集合：f[i]是已分配元素集合的不兼容性的和
 * 2. 状态计算
 * f[mask | next] = min(f[mask | next], f[mask] + mp.get(next))
 */
public class M1681_最小不兼容性 {
    private static int INF = 0x3f3f3f3f;

    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int group = n / k;
        int[] f = new int[1 << n];
        Arrays.fill(f, INF);
        f[0] = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int mask = 1; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != group) { // 略过组数不为n/k的情况
                continue;
            }
            int mn = 20, mx = 0; // mn只要取大于16的值即可
            HashSet<Integer> cur = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    if (cur.contains(nums[i])) {
                        break;
                    }
                    cur.add(nums[i]);
                    mn = Math.min(mn, nums[i]);
                    mx = Math.max(mx, nums[i]);
                }
            }
            if (cur.size() == group) {
                mp.put(mask, mx - mn);
            }
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            if (f[mask] == INF) { // 只考虑可行的情况
                continue;
            }
            HashMap<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    seen.put(nums[i], i);
                }
            }
            if (seen.size() < group) {
                continue;
            }
            int sub = 0;
            for (int v : seen.values()) {
                sub |= (1 << v);
            }
            int next = sub;
            while (next > 0) {
                if (mp.containsKey(next)) {
                    f[mask | next] = Math.min(f[mask | next], f[mask] + mp.get(next));
                }
                next = (next - 1) & sub;
            }
        }

        return (f[(1 << n) - 1] < INF) ? f[(1 << n) - 1] : -1;
    }
}
