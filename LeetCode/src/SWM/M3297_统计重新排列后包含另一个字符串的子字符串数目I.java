package SWM;

/**
 * @author Hyperspace
 * @date 2025/01/09
 * @file M3297_统计重新排列后包含另一个字符串的子字符串数目I.java
 * <p>
 * 思路
 * SWM
 * 参考Q76
 */
public class M3297_统计重新排列后包含另一个字符串的子字符串数目I {
    public long validSubstringCount(String word1, String word2) {
        char[] s = word1.toCharArray(), t = word2.toCharArray();
        int n = s.length;
        int[] cnt = new int[26], cur = new int[26];
        for (char c : t) {
            cnt[c - 'a']++;
        }
        long ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cur[s[r] - 'a']++;
            while (check(cur, cnt)) {
                ans += n - r;
                cur[s[l++] - 'a']--;
            }
        }

        return ans;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }

        return true;
    }
}
