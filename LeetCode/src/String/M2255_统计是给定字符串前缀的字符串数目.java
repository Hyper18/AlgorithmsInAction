package String;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/03/24
 * @file M2255_统计是给定字符串前缀的字符串数目.java
 * <p>
 * 思路
 * 调库
 */
public class M2255_统计是给定字符串前缀的字符串数目 {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.indexOf(word) == 0) {
                ans++;
            }
        }

        return ans;
    }

    public int countPrefixes2(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }

        return ans;
    }

    public int countPrefixes3(String[] words, String s) {
        return (int) Arrays.stream(words).filter(w -> w.length() <= s.length() && w.equals(s.substring(0, w.length()))).count();
    }
}
