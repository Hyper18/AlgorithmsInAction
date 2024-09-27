package SWM;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/09/27
 * @file M2516_每种字符至少取K个.java
 * <p>
 * 思路
 * SWM，挺好的一道题
 * 维护窗口外的字母个数
 * 预先判断各字母是否有足够的数目
 * 中间滑窗内的子串是保留的，取走两侧
 * 每当cnt不足时，从窗口内移除左端点元素并取走
 * 否则，维护当前的窗口长度
 */
public class M2516_每种字符至少取K个 {
    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] cnt = new int[3];
        for (char c : cs) {
            cnt[c - 'a']++;
        }
        if (Arrays.stream(cnt).min().getAsInt() < k) {
            return -1;
        }
        int l = 0, r = 0, len = 0;
        while (r < n) {
            cnt[cs[r++] - 'a']--;
            if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
                cnt[cs[l++] - 'a']++;
            } else {
                len = Math.max(len, r - l);
            }
        }

        return n - len;
    }
}
