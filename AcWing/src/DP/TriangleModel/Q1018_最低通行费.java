package DP.TriangleModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/08
 */
public class Q1018_最低通行费 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10, INF = 0x3f3f3f3f;
    private static int[][] w = new int[N][N], f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    f[i][j] = w[i][j];
                } else {
                    f[i][j] = INF;
                    if (i > 1) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + w[i][j]);
                    }
                    if (j > 1) {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + w[i][j]);
                    }
                }
            }
        }
        out.println(f[n][n]);
        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
