package ref;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/29
 */
public class R24_最大公共子序列LCS {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAXD = 10000 + 10;
    private static int[][] dp = new int[MAXD][MAXD];
    static int lenX, lenY;

    public static void main(String[] args) throws IOException {
        String s1 = nextString();
        String s2 = nextString();
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        lenX = x.length;
        lenY = y.length;

        lcsLength(x, y);
        int rLen = dp[s1.length()][s2.length()];
        out.println(rLen);

        char[] ans = lcsStr(x, y);
        for (int i = rLen - 1; i >= 0; i--) {
            if (i == 0) {
                out.println(ans[i]);
                break;
            }
            out.print(ans[i]);
        }

        close();
    }

    /**
     * 求两子串的最长公共子序列
     *
     * @param x 子串x
     * @param y 子串y
     * @return 包含最长公共子序列的字符数组
     */
    private static char[] lcsStr(char[] x, char[] y) {
        char[] ch = new char[MAXD];
        int idx = 0, i = lenX, j = lenY;
        while (i != 0 && j != 0) {
            if (x[i - 1] == y[j - 1]) {
                ch[idx++] = x[--i];
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return ch;
    }

    /**
     * 求两子串的最长公共子序列长度
     *
     * @param x 子串x
     * @param y 子串y
     */
    private static void lcsLength(char[] x, char[] y) {
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
