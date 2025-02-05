package Array;

/**
 * @author Hyper
 * @date 2024/10/30
 * @file M3216_交换后字典序最小的字符串.java
 */
public class M3216_交换后字典序最小的字符串 {
    public String getSmallestString(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (c[i] > c[i + 1] && c[i] % 2 == c[i + 1] % 2) {
                char t = c[i];
                c[i] = c[i + 1];
                c[i + 1] = t;
                break;
            }
        }

        return new String(c);
    }
}
