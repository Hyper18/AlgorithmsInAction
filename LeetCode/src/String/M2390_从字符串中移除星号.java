package String;

/**
 * @author Hyper
 * @date 2024/09/14
 * @file M2390_从字符串中移除星号.java
 */
public class M2390_从字符串中移除星号 {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
