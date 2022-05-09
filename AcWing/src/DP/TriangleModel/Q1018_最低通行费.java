package DP.TriangleModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/08
 * <p>
 * 思路 dp
 * 1. 状态表示
 * 1) 属性: 走到第i行第j列的所有方案
 * 2) 集合: 所有物品的总价值最小Min
 * 2. 状态转移
 * f[i][j] = min(f[i - 1][j], f[i][j - 1]) + w[i][j]
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
                f[i][j] = INF;
            }
        }

        f[1][1] = w[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (i > 1) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + w[i][j]);
                }
                if (j > 1) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + w[i][j]);
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
