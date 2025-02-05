package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/09/19
 * @file M2414_最长的字母序连续子字符串的长度.java
 * <p>
 * 思路
 * 1. 模拟 - O(n^2)
 * 2. 优化 - O(n)
 * 3. 去掉特判
 * 4. DP
 * 1. 状态表示
 * 集合：f[i]是以s[i]为结尾的连续字符串的最大长度
 * 属性：max
 * 2. 状态计算
 * 1) 满足字典序，转移状态
 * f[i] = f[i - 1] + 1
 * 2) 不满足字典序，维持原状态
 * f[i] = 1
 */
public class M2414_最长的字母序连续子字符串的长度 {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if (n == 1) {
            return n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) - s.charAt(j - 1) == 1) {
                    cnt++;
                } else {
                    ans = Math.max(ans, cnt);
                    cnt = 0;
                    break;
                }
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public int longestContinuousSubstring2(String s) {
        int n = s.length();
        if (n == 1) {
            return n;
        }
        int ans = 0, cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }

        return Math.max(ans, cnt);
    }

    public int longestContinuousSubstring3(String s) {
        int n = s.length();
        int ans = 1, cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }

        return Math.max(ans, cnt);
    }

    public int longestContinuousSubstring4(String s) {
        int n = s.length();
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = s.charAt(i) - s.charAt(i - 1) == 1 ? f[i - 1] + 1 : 1;
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
