package TwoPointer;

/**
 * @author Hyper
 * @date 2025/02/03
 * @file M680_验证回文串II.java
 */
public class M680_验证回文串II {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int l = 0, r = n - 1; l < r; l++, r--) {
            if (cs[l] == cs[r]) {
                continue;
            }
            return f(cs, l + 1, r) || f(cs, l, r - 1);
        }

        return true;
    }

    private boolean f(char[] cs, int l, int r) {
        while (l < r) {
            if (cs[l++] != cs[r--]) {
                return false;
            }
        }

        return true;
    }
}
