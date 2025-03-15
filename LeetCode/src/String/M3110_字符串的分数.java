package String;

/**
 * @author Hyperspace
 * @date 2025/03/15
 * @file M3110_字符串的分数.java
 */
public class M3110_字符串的分数 {
    public int scoreOfString(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return ans;
    }
}
