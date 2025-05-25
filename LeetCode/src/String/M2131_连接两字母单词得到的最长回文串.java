package String;

/**
 * @author Hyperspace
 * @date 2025/05/25
 * @file M2131_连接两字母单词得到的最长回文串.java
 * <p>
 * 思路
 * 模拟，哈希
 */
public class M2131_连接两字母单词得到的最长回文串 {
    public int longestPalindrome(String[] words) {
        int[][] mp = new int[26][26];
        int ans = 0;
        for (String s : words) {
            int i = s.charAt(0) - 'a', j = s.charAt(1) - 'a';
            if (mp[j][i] > 0) {
                mp[j][i]--;
                ans += 4;
                continue;
            }
            mp[i][j]++;
        }
        for (int i = 0; i < 26; i++) {
            if (mp[i][i] > 0) {
                ans += 2;
                break;
            }
        }

        return ans;
    }
}
