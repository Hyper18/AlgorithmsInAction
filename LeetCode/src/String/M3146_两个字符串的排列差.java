package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/08/24
 * @file M3146_两个字符串的排列差.java
 * <p>
 * 思路
 * 模拟
 * 1. 直接遍历
 * 2. 转char[]数组后遍历
 * 3. 开辅助数组
 * 4. 用hash也是可以的
 */
public class M3146_两个字符串的排列差 {
    public int findPermutationDifference(String s, String t) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(i - t.indexOf(s.charAt(i)));
        }

        return ans;
    }

    public int findPermutationDifference2(String s, String t) {
        int ans = 0, i = 0;
        for (char c : s.toCharArray()) {
            int j = t.indexOf(c);
            ans += i > j ? i - j : j - i;
            i++;
        }

        return ans;
    }

    public int findPermutationDifference3(String s, String t) {
        int n = s.length();
        int[] pos = new int[26];
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(i - pos[t.charAt(i) - 'a']);
        }

        return ans;
    }

    public int findPermutationDifference4(String s, String t) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(s.charAt(i), i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(i - mp.get(t.charAt(i)));
        }

        return ans;
    }
}
