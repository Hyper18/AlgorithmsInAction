package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/10/11
 * @file M3164_优质数对的总数II.java
 * <p>
 * 思路
 * 用暴力做自然会TLE
 * 根据hint 1~3
 * 依次枚举nums1[i]/k的因子，与nums2做匹配
 * 也可以枚举nums2[i]的倍数
 */
public class M3164_优质数对的总数II {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums1) {
            if (v % k != 0) {
                continue;
            }
            v /= k;
            for (int d = 1; d * d <= v; d++) {
                if (v % d > 0) {
                    continue;
                }
                mp.merge(d, 1, Integer::sum);
                if (d * d < v) {
                    mp.merge(v / d, 1, Integer::sum);
                }
            }
        }
        long ans = 0;
        for (int v : nums2) {
            ans += mp.getOrDefault(v, 0);
        }

        return ans;
    }
}
