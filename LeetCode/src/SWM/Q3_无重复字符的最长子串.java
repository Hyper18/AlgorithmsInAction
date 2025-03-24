package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/02/24，2023/02/28，2025/02/06，2025/03/24
 * <p>
 * 思路
 * SWM
 * 1. 哈希 记录cnt
 * 2. 字符串处理
 * 3. 哈希 记录pos
 * 4. 同向SWM -- O(n)
 */
public class Q3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            mp.merge(cs[r], 1, Integer::sum);
            while (mp.get(cs[r]) > 1) {
                mp.merge(cs[l], -1, Integer::sum);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (char c : s.toCharArray()) {
            int idx = sb.toString().indexOf(c);
            if (idx >= 0) {
                sb = new StringBuilder(sb.substring(idx + 1));
            }
            sb.append(c);
            ans = Math.max(ans, sb.length());
        }

        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (mp.containsKey(cs[r])) {
                l = Math.max(l, mp.get(cs[r]) + 1);
            }
            mp.put(cs[r], r);
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public int lengthOfLongestSubstring4(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            mp.merge(cs[r], 1, Integer::sum);
            while (mp.get(cs[r]) > 1) {
                mp.merge(cs[l++], -1, Integer::sum);
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
