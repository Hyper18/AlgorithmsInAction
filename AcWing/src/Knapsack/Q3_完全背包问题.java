package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/17
 */
public class Q3_完全背包问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 1000 + 10;
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();
        for (int i = 1; i <= N; i++) {
            int v = nextInt();
            int w = nextInt();
            for (int j = v; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v] + w);
            }
        }

        out.println(dp[V]);

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
