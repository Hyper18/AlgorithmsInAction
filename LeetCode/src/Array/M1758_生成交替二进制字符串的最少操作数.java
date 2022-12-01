package Array;

/**
 * @author Hyperspace
 * @date 2022/11/29
 * @file M1758_生成交替二进制字符串的最少操作数.java
 */
public class M1758_生成交替二进制字符串的最少操作数 {
    public int minOperations(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }

        return Math.min(cnt, n - cnt);
    }
}
