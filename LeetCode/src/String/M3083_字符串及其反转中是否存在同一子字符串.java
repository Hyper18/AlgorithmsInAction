package String;

/**
 * @author Hyperspace
 * @date 2024/12/26
 * @file M3083_字符串及其反转中是否存在同一子字符串.java
 */
public class M3083_字符串及其反转中是否存在同一子字符串 {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s).reverse();
        for (int l = 0; l < n - 1; l++) {
            if (sb.indexOf(s.substring(l, l + 2)) >= 0) {
                return true;
            }
        }

        return false;
    }
}
