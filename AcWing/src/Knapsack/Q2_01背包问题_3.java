package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/17
 * 转化为一维dp
 */
public class Q2_01背包问题_3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 1000 + 10;
    private static int[] v = new int[MAX];
    private static int[] w = new int[MAX];
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();
        for (int i = 1; i <= N; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        out.println(dp[V]);

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