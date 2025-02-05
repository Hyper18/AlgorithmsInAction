package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/17
 * 朴素二维dp
 */
public class Q2_01背包问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 1000 + 10;
    private static int[] v = new int[MAX];
    private static int[] w = new int[MAX];
    private static int[][] f = new int[MAX][MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, f[n][i]);
        }

        out.println(res);

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