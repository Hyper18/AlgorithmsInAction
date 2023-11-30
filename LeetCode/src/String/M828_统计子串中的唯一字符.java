package String;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/11/26
 * @file M828_统计子串中的唯一字符.java
 * <p>
 * 思路
 * 模拟，乘法原理
 */
public class M828_统计子串中的唯一字符 {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] l = new int[n], r = new int[n];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = idx[u];
            idx[u] = i;
        }
        Arrays.fill(idx, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = idx[u];
            idx[u] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }

        return ans;
    }
}
