package SWM;

/**
 * @author Hyperspace
 * @date 2023/03/04
 * @file Q395_至少有K个重复字符的最长子串.java
 * <p>
 * 思路
 * 双指针，模拟
 * 每次左移1，找单次窗口的最大宽度
 */
public class Q395_至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int l = 0; l < n - k + 1; l++) {
            int r = l;
            int[] cnts = new int[26];
            while (r < n) {
                char c = s.charAt(r);
                cnts[c - 'a']++;
                if (r - l + 1 >= k && check(cnts, k)) {
                    ans = Math.max(ans, r - l + 1);
                }
                r++;
            }
        }

        return ans;
    }

    private boolean check(int[] cnts, int k) {
        for (int cnt : cnts) {
            if (cnt != 0 && cnt < k) {
                return false;
            }
        }
        return true;
    }
}
