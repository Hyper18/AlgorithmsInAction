package String;

/**
 * @author Hyperspace
 * @date 2025/06/10
 * @file M3442_奇偶频次间的最大差值I.java
 * <p>
 * 思路
 * 模拟
 */
public class M3442_奇偶频次间的最大差值I {
    public int maxDifference(String s) {
        int n = s.length();
        int[] mp = new int[26];
        for (int i = 0; i < n; i++) {
            mp[s.charAt(i) - 'a']++;
        }
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (mp[i] == 0) {
                continue;
            }
            if (mp[i] % 2 == 1 && mp[i] > mx) {
                mx = mp[i];
            }
            if (mp[i] % 2 == 0 && mp[i] < mn) {
                mn = mp[i];
            }
        }

        return mx - mn;
    }
}
