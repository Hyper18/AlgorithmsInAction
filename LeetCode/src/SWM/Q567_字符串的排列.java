package SWM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/02/24，2023/03/04
 * <p>
 * 思路
 * 1. 先分别统计s1长度下两数组的字母计数，再遍历s2剩余长度部分并逐次验证
 * 2. SWM array写法
 * 3. SWM hash写法
 */
public class Q567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < len1; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n1 = s1.length(), n2 = s2.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (char c : s1.toCharArray()) {
            cnt1[c - 'a']++;
        }
        int cnt = 0, l = 0, r = 0;
        while (r < n2) {
            char cr = s2.charAt(r);
            if (cnt1[cr - 'a'] != 0) {
                if (++cnt2[cr - 'a'] == cnt1[cr - 'a']) {
                    cnt++;
                }
            }
            if (r - l + 1 == n1) {
                int size = 0;
                for (int c : cnt1) {
                    if (c != 0) {
                        size++;
                    }
                }
                if (cnt == size) {
                    return true;
                }
                char cl = s2.charAt(l);
                if (cnt1[cl - 'a'] != 0) {
                    if (cnt2[cl - 'a']-- == cnt1[cl - 'a']) {
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }

        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n1 = s1.length(), n2 = s2.length();
        Map<Character, Integer> cnt1 = new HashMap<>(), cnt2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            cnt1.put(c, cnt1.getOrDefault(c, 0) + 1);
        }
        int cnt = 0, l = 0, r = 0;
        while (r < n2) {
            char cr = s2.charAt(r);
            if (cnt1.containsKey(cr)) {
                cnt2.put(cr, cnt2.getOrDefault(cr, 0) + 1);
                if (cnt2.get(cr).equals(cnt1.get(cr))) {
                    cnt++;
                }
            }
            if (r - l + 1 == n1) {
                char cl = s2.charAt(l);
                if (cnt == cnt1.size()) {
                    return true;
                }
                if (cnt1.containsKey(cl)) {
                    if (cnt2.get(cl).equals(cnt1.get(cl))) {
                        cnt--;
                    }
                    cnt2.put(cl, cnt2.get(cl) - 1);
                }
                l++;
            }
            r++;
        }

        return false;
    }
}
