package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/03/02
 * @file Q76_最小覆盖子串.java
 * <p>
 * 思路
 * SWM
 * 题目为求包含t中所有出现字母的最小串
 * 左指针在恰符合要求时，记录最短串后移动
 * mp1.get(cr) <= mp2.getOrDefault(cr, 0)
 * 处理在t中，而s中出现次数超过t的字母，超过所需不参与cnt总数
 * 否则，如s=bba，t=ab，则遍历前两位后就会使得cnt=2触发窗口右移，但此时的最小串不含a，并不符合要求
 * 1. hash的写法
 * 2. array的写法
 * 58是因为ASCII码A-a间隔32，a-z长26，32 + 26 = 58
 */
public class Q76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        Map<Character, Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);
        }
        int minL = 0, minR = n1, cnt = 0, l = 0, r = 0;
        while (r < n1) {
            char cr = s.charAt(r);
            mp1.put(cr, mp1.getOrDefault(cr, 0) + 1);
            if (mp1.get(cr) <= mp2.getOrDefault(cr, 0)) {
                cnt++;
            }
            while (cnt == n2) {
                if (minR - minL > r - l) {
                    minL = l;
                    minR = r;
                }
                char cl = s.charAt(l);
                if (mp1.get(cl) <= mp2.getOrDefault(cl, 0)) {
                    cnt--;
                }
                mp1.put(cl, mp1.get(cl) - 1);
                l++;
            }
            r++;
        }

        return minR == n1 ? "" : s.substring(minL, minR + 1);
    }

    public String minWindow2(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[] cnt1 = new int[58], cnt2 = new int[58];
        for (char c : t.toCharArray()) {
            cnt2[c - 'A']++;
        }
        int minL = 0, minR = n1, cnt = 0, l = 0, r = 0;
        while (r < n1) {
            char cr = s.charAt(r);
            if (++cnt1[cr - 'A'] <= cnt2[cr - 'A']) {
                cnt++;
            }
            while (cnt == n2) {
                if (minR - minL > r - l) {
                    minL = l;
                    minR = r;
                }
                char cl = s.charAt(l);
                if (cnt1[cl - 'A']-- <= cnt2[cl - 'A']) {
                    cnt--;
                }
                l++;
            }
            r++;
        }

        return minR == n1 ? "" : s.substring(minL, minR + 1);
    }
}
