package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/19
 * 思路
 * hash || array
 * 1. 存字符 -- O(n)
 * 2，存索引 -- O(n)
 */
public class Q387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar_2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] arr = new int[26];

        for (int i = 0; i < len; i++) {
            int idx = chars[i] - 'a';
            arr[idx]++;
        }
        for (int i = 0; i < len; i++) {
            int idx = chars[i] - 'a';
            if (arr[idx] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }

        int ans = len;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < ans) {
                ans = pos;
            }
        }

        return ans == len ? -1 : ans;
    }

}
