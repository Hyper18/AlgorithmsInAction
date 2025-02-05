package String.KMP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/12/17
 * @file M3291_形成目标字符串需要的最少字符串数I1.java
 * <p>
 * 思路
 * z函数+KMP+DP
 * z[i]表示s[i:]与s的最长公共前缀
 * <p>
 * “#”是避免z[i]超过word的长度
 * target[i:]与word的最长公共前缀是z[m+1+i]
 */
public class M3291_形成目标字符串需要的最少字符串数I2 {
    private final int N = (int) 5e3;

    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] back = new int[n];
        for (String word : words) {
            int[] z = calZ(word, target);
            int m = word.length();
            for (int i = 0; i < n; i++) {
                back[i] = Math.max(back[i], z[m + 1 + i]);
            }
        }
        int[] f = new int[n + 1];
        Arrays.fill(f, 1, n + 1, N);
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i + 1 - back[i]] + 1;
            if (f[i + 1] > n) {
                return -1;
            }
        }

        return f[n];
    }

    private int[] calZ(String word, String t) {
        char[] s = (word + "#" + t).toCharArray();
        int n = s.length;
        int[] z = new int[n];
        for (int i = 1; i < n; i++) {
            int j = z[i - 1];
            while (j > 0 && s[i] != s[j]) {
                j = z[j - 1];
            }
            if (s[i] == s[j]) {
                j++;
            }
            z[i] = j;
        }

        return z;
    }
}
