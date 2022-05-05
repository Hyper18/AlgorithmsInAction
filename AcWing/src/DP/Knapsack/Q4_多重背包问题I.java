package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 * 多重背包问题
 */
public class Q4_多重背包问题I {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100 + 10;
    private static int[] f = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        for (int i = 1; i <= n; i++) {
            int v = nextInt();
            int w = nextInt();
            int s = nextInt();
            for (int j = m; j >= v; j--) {
                for (int k = 1; k <= s && k * v <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
            }
        }

        out.println(f[m]);

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
