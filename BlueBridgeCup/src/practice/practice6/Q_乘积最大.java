package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/24
 * 40/100
 */
public class Q_乘积最大 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 1000000000 + 9;
    private static final int INF = 0x3f3f3f3f;
    private static final int MAX = 10000 + 9;
    private static long[][] dp = new long[MAX][MAX];
    private static int[] a = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][1] = Math.max(dp[i][1], a[j]);
            }
        }
        for (int i = 1; i <= n; i++) {
            long sum = 1;
            for (int j = 1; j <= i; j++) {
                sum *= a[j];
            }
            dp[i][i] = sum;
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] * a[i]);
            }
        }

        out.println(executeMod(dp[n][k]));

        close();
    }

    private static long executeMod(long x) {
        return x >= 0 ? x % MOD : 0 - ((0 - x) % MOD);
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
