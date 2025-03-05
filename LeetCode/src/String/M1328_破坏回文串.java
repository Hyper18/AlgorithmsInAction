package String;

/**
 * @author Hyper
 * @date 2025/03/05
 * @file M1328_破坏回文串.java
 */
public class M1328_破坏回文串 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] cs = palindrome.toCharArray();
        int n = cs.length;
        boolean flag = false;
        for (int l = 0; l < n / 2; l++) {
            if (cs[l] == 'a') {
                continue;
            }
            cs[l] = 'a';
            flag = true;
            break;
        }
        if (!flag) {
            cs[n - 1] = cs[n - 1] == 'a' ? 'b' : 'a';
        }

        return new String(cs);
    }
}
