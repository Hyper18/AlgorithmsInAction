package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/11
 * @time 93ms
 * <p>
 * dp[i][j]表示对于抽取i次，共有j种印章
 * 状态转移方程注意j=1的情况
 */
public class D_算法训练_印章 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        double prob = 1D / n;

        double[][] dp = new double[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j) {
                    dp[i][j] = 0;
                } else if (j == 1) {
                    dp[i][j] = Math.pow(prob, i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] * j * prob + dp[i - 1][j - 1] * (n - (j - 1)) * prob;
                }
            }
        }

        out.printf("%.4f\n", dp[m][n]);

        close();
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
