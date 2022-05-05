package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 * 二维费用的背包问题
 */
public class Q8_二维费用的背包问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100 + 10;
    private static int[][] dp = new int[MAX][MAX];

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();
        int M = nextInt();
        for (int i = 1; i <= N; i++) {
            int v = nextInt();
            int m = nextInt();
            int w = nextInt();

            for (int j = V; j >= v; j--) {
                for (int k = M; k >= m; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v][k - m] + w);
                }
            }
        }

        out.println(dp[V][M]);

        close();
    }

    private static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(token.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
