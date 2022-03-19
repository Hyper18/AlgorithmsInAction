package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 * 分组背包问题
 */
public class Q9_分组背包问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100 + 10;
    private static int[] dp = new int[MAX];
    private static int[] v = new int[MAX];
    private static int[] w = new int[MAX];

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();
        for (int i = 1; i <= N; i++) {
            int S = nextInt();
            for (int j = 1; j <= S; j++) {
                v[j] = nextInt();
                w[j] = nextInt();
            }
            for (int j = V; j >= 0; j--) {
                for (int k = 1; k <= S; k++) {
                    // 区分循环条件与终止条件
                    if (v[k] > j) {
                        continue;
                    }
                    dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);
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
