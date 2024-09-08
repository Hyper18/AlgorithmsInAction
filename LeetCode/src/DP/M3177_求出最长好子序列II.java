package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/09/07
 * @file M3177_求出最长好子序列II.java
 */
public class M3177_求出最长好子序列II {
    public int maximumLength(int[] nums, int k) {
        Map<Integer, int[]> mp = new HashMap<>();
        int[] record = new int[k + 2];
        for (int num : nums) {
            if (!mp.containsKey(num)) {
                mp.put(num, new int[k + 1]);
            }
            for (int l = k; l >= 0; l--) {
                int[] f = mp.get(num);
                f[l] = Math.max(f[l], record[l]) + 1;
                record[l + 1] = Math.max(record[l + 1], f[l]);
            }
        }

        return record[k + 1];
    }

    public int maximumLength2(int[] nums, int k) {
        Map<Integer, int[]> mp = new HashMap<>();
        int[] record = new int[k + 2];
        for (int num : nums) {
            int[] f = mp.computeIfAbsent(num, i -> new int[k + 1]);
            for (int j = k; j >= 0; j--) {
                f[j] = Math.max(f[j], record[j]) + 1;
                record[j + 1] = Math.max(record[j + 1], f[j]);
            }
        }
        return record[k + 1];
    }
}
