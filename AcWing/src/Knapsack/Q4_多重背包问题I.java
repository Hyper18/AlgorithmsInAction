package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 */
public class Q4_多重背包问题I {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100 + 10;
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();
        for (int i = 1; i <= N; i++) {
            int v = nextInt();
            int w = nextInt();
            int s = nextInt();
            for (int j = V; j >= v; j--) {
                for (int k = 1; k <= s && k * v <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v] + k * w);
                }
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
