package String;

import java.util.*;

/**
 * @author Hyper
 * @date 2025/02/07
 * @file Q438_找到字符串中所有字母异位词.java
 * <p>
 * 思路
 * 1. SWM+字符串处理 1101ms。。
 * 2. 定长SWM
 * 3. 不定长SWM
 */
public class Q438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] cs = s.toCharArray(), ps = p.toCharArray();
        Arrays.sort(ps);
        int n = cs.length, m = ps.length;
        Map<Character, Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        for (int l = 0, r = 0; r < n; r++) {
            if (p.indexOf(cs[r]) < 0) {
                sb = new StringBuilder();
                mp.clear();
                l = r + 1;
                continue;
            }
            if (r - l + 1 > m) {
                mp.remove(cs[l]);
                sb.deleteCharAt(0);
                int idx = sb.toString().indexOf(cs[l]);
                if (idx >= 0) {
                    mp.put(cs[l], l + 1 + idx);
                }
                l++;
            }
            mp.putIfAbsent(cs[r], r);
            sb.append(cs[r]);
            if (sb.length() == m) {
                char[] ss = sb.toString().toCharArray();
                int pos = mp.get(ss[0]);
                Arrays.sort(ss);
                if (new String(ps).equals(new String(ss))) {
                    res.add(pos);
                }
            }
        }

        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        char[] cs = s.toCharArray(), ps = p.toCharArray();
        int sLen = cs.length, pLen = ps.length;
        if (pLen > sLen) {
            return new ArrayList<>();
        }
        int[] sCnt = new int[26], pCnt = new int[26];
        for (char c : ps) {
            pCnt[c - 'a']++;
        }
        for (int i = 0; i < pLen; i++) {
            sCnt[cs[i] - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(sCnt, pCnt)) {
            res.add(0);
        }
        for (int r = pLen; r < sLen; r++) {
            sCnt[cs[r - pLen] - 'a']--;
            sCnt[cs[r] - 'a']++;
            int l = r - pLen + 1;
            if (Arrays.equals(sCnt, pCnt)) {
                res.add(l);
            }
        }

        return res;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        char[] cs = s.toCharArray(), ps = p.toCharArray();
        int sLen = cs.length, pLen = ps.length;
        if (pLen > sLen) {
            return new ArrayList<>();
        }
        int[] cnt = new int[26];
        for (char c : ps) {
            cnt[c - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        for (int l = 0, r = 0; r < sLen; r++) {
            cnt[cs[r] - 'a']--;
            while (cnt[cs[r] - 'a'] < 0) {
                cnt[cs[l++] - 'a']++;
            }
            if (pLen == r - l + 1) {
                res.add(l);
            }
        }

        return res;
    }
}
