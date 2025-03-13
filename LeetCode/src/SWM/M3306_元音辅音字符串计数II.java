package SWM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/03/13
 * @file M3306_元音辅音字符串计数II.java
 * <p>
 * 思路
 * 恰好型滑窗
 * 普通的单滑窗是不可行的
 * <p>
 * 待回看
 */
public class M3306_元音辅音字符串计数II {
    private Set<Character> ch = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public long countOfSubstrings(String word, int k) {
        char[] cs = word.toCharArray();
        return count(cs, k) - count(cs, k + 1);
    }

    private long count(char[] cs, int k) {
        long ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        int cnt = 0;
        int l = 0;
        for (int r = 0; r < cs.length; r++) {
            if (ch.contains(cs[r])) {
                mp.merge(cs[r], 1, Integer::sum);
            } else {
                cnt++;
            }
            while (cnt >= k && mp.size() == 5) {
                if (ch.contains(cs[l])) {
                    if (mp.merge(cs[l], -1, Integer::sum) == 0) {
                        mp.remove(cs[l]);
                    }
                } else {
                    cnt--;
                }
                l++;
            }
            ans += l;
        }

        return ans;
    }
}
