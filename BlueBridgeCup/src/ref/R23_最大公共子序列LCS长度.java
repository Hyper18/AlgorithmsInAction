package ref;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/29
 */
public class R23_最大公共子序列LCS长度 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAXD = 10000 + 10;
    private static int[][] dp = new int[MAXD][MAXD];

    public static void main(String[] args) throws IOException {
        String s1 = nextString();
        String s2 = nextString();

        lcsLength(s1.toCharArray(), s2.toCharArray());

        out.println(dp[s1.length()][s2.length()]);

        close();
    }

    /**
     * 求两子串的最长公共子序列长度
     *
     * @param x 子串x
     * @param y 子串y
     */
    private static void lcsLength(char[] x, char[] y) {
        int lenX = x.length;
        int lenY = y.length;

        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 当前位置的两数不相等时，选择两串中的最大子串
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public static String nextString() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
