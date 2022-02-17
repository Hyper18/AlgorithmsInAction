package DP;

/**
 * @author Hyperspace
 * @date 2022/02/17
 * <p>
 * 思路
 * 追加空格作为哨兵可避免讨论前导零
 */
public class Q91_解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        s = sb.append(" ").append(s).toString();
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = chars[i] - '0';
            int b = chars[i] - '0' + (chars[i - 1] - '0') * 10;
            if (a >= 1 && a <= 9) {
                // 数组元素默认为0
                dp[i] = dp[i - 1];
            }
            if (b >= 10 && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        s = sb.append(" ").append(s).toString();
        char[] chars = s.toCharArray();
        int[] dp = new int[3];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i % 3] = 0;
            int a = chars[i] - '0';
            int b = chars[i] - '0' + (chars[i - 1] - '0') * 10;
            if (a >= 1 && a <= 9) {
                dp[i % 3] = dp[(i - 1) % 3];
            }
            if (b >= 10 && b <= 26) {
                dp[i % 3] += dp[(i - 2) % 3];
            }
        }
        return dp[n % 3];
    }
}
