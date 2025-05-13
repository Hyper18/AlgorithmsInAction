package String;

/**
 * @author Hyper
 * @date 2025/05/13
 * @file M3335_字符串转换后的长度I.java
 * <p>
 * 思路
 * 模拟 -- O(n)
 * 本质在于找新字母的产生点
 * 每26轮，有：
 * a~y -> ab, bc, ..., yz
 * z -> zab
 */
public class M3335_字符串转换后的长度I {
    private final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t) {
        char[] cs = s.toCharArray();
        int[] mp = new int[26];
        for (char c : cs) {
            mp[c - 'a']++;
        }
        while (t >= 26) {
            int r = mp[25];
            for (int i = 24; i >= 0; i--) {
                mp[i + 1] = (mp[i + 1] + mp[i]) % MOD;
            }
            mp[0] = (mp[0] + r) % MOD;
            mp[1] = (mp[1] + r) % MOD;
            t -= 26;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int cur = (mp[i] + (t >= 26 - i ? mp[i] : 0)) % MOD;
            ans = (ans + cur) % MOD;
        }

        return ans;
    }
}
