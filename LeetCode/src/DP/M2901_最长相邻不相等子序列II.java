package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/16
 * @file M2901_最长相邻不相等子序列II.java
 * <p>
 * 思路@ylb
 * DP
 */
public class M2901_最长相邻不相等子序列II {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[] f = new int[n], g = new int[n];
        Arrays.fill(f, 1);
        Arrays.fill(g, -1);
        int mx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && f[i] < f[j] + 1 && check(words[i], words[j])) {
                    f[i] = f[j] + 1;
                    g[i] = j;
                    mx = Math.max(mx, f[i]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (f[i] == mx) {
                for (int j = i; j >= 0; j = g[j]) {
                    res.add(words[j]);
                }
                break;
            }
        }
        Collections.reverse(res);

        return res;
    }

    private boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
        }

        return cnt == 1;
    }
}
