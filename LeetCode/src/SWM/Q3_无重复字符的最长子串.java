package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/24
 */
public class Q3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int left = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (map.containsKey(ss[i])) {
                left = Math.max(left, map.get(ss[i]) + 1);
            }
            map.put(ss[i], i);
            cnt = Math.max(cnt, i - left + 1);
        }

        return cnt;
    }
}
