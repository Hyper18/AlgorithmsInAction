package String;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/19
 * <p>
 * 1. 快乐排序
 * 2. array
 */
public class Q242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
