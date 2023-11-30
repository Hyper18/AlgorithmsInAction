package String;

/**
 * @author Hyperspace
 * @date 2023/11/08
 * @file M2609_最长平衡子字符串.java
 * <p>
 * 思路
 * 模拟
 */
public class M2609_最长平衡子字符串 {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int len = 0;
            for (int l = i - 1, r = i; l >= 0 && r < n; l--, r++, len += 2) {
                if (s.charAt(l) != '0' || s.charAt(r) != '1') {
                    break;
                }
            }
            ans = Math.max(ans, len);
        }

        return ans;
    }
}
