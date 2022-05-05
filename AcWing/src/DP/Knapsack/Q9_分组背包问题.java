package DP.Knapsack;

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
    private static int[] f = new int[MAX];
    private static int[] v = new int[MAX];
    private static int[] w = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        for (int i = 1; i <= n; i++) {
            int s = nextInt();
            for (int j = 1; j <= s; j++) {
                v[j] = nextInt();
                w[j] = nextInt();
            }
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s; k++) {
                    // 区分循环条件与终止条件
                    if (v[k] > j) {
                        continue;
                    }
                    f[j] = Math.max(f[j], f[j - v[k]] + w[k]);
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
