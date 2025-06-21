package Greedy;

/**
 * @author Hyperspace
 * @date 2025/06/21
 * @file M3085_成为K特殊字符串需要删除的最少字符数.java
 * <p>
 * 思路
 * 贪心
 */
public class M3085_成为K特殊字符串需要删除的最少字符数 {
    public int minimumDeletions(String word, int k) {
        char[] cs = word.toCharArray();
        int[] mp = new int[26];
        for (char c : cs) {
            mp[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            int t = mp[i] + k, cnt = 0;
            for (int j = 0; j < 26; j++) {
                if (mp[j] == 0) {
                    continue;
                }
                if (mp[j] > t) {
                    cnt += mp[j] - t;
                }
                if (mp[i] > mp[j]) {
                    cnt += mp[j];
                }
            }
            ans = Math.min(ans, cnt);
        }

        return ans;
    }
}
