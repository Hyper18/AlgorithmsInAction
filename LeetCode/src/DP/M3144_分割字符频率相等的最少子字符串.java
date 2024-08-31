package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/08/28
 * @file M3144_分割字符频率相等的最少子字符串.java
 * <p>
 * 思路
 * DP
 * 对于到第i位的字符串，每一个字符都构成一个平衡子字符串，合i+1个
 * 统计每种字符出现的次数
 * 满足check条件则
 * 1) j == 0
 * f[i] = 1
 * 2) j != 0
 * f[i] = min(f[i], f[j - 1] + 1)
 */
public class M3144_分割字符频率相等的最少子字符串 {
    Map<Character, Integer> mp = new HashMap<>();

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                mp.merge(s.charAt(j), 1, Integer::sum);
                if (check(i - j + 1)) {
                    f[i] = j == 0 ? 1 : Math.min(f[i], f[j - 1] + 1);
                }
            }
            mp.clear();
        }

        return f[n - 1];
    }

    private boolean check(int len) {
        if (len % mp.size() != 0) {
            return false;
        }
        int cnt = len / mp.size();
        for (int v : mp.values()) {
            if (v != cnt) {
                return false;
            }
        }

        return true;
    }
}
