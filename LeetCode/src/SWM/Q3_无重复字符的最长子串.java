package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/24，2023/02/28
 * <p>
 * 思路 SWM
 * 1. hash
 * 2. string
 */
public class Q3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, end);
            cnt = Math.max(cnt, end - start + 1);
        }

        return cnt;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0, l = 0, r = 0;
        String t = "";
        while (r < n) {
            char c = s.charAt(r);
            int idx = t.indexOf(c);
            if (idx >= 0) {
                l = idx + 1;
                t = t.substring(l);
            }
            t += c;
            ans = Math.max(ans, t.length());
            r++;
        }

        return ans;
    }
}
