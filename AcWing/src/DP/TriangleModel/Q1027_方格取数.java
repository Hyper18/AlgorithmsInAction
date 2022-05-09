package DP.TriangleModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/09
 * 思路 dp
 * 1. 状态表示
 * 1) 属性: 走到第i行第j列的所有方案
 * 2) 集合: 所有物品的总价值最小Max
 * 2. 状态转移
 * f[i][j] = max(f[i - 1][j], f[i][j - 1]) + w[i][j]
 */
public class Q1027_方格取数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10 + 3;
    private static int[][] w = new int[N][N];
    private static int[][][] f = new int[N * 2][N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (true) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            w[a][b] = c;
        }

        for (int k = 2; k <= n * 2; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 < 1 || j1 > n || j2 < 1 || j2 > n) {
                        continue;
                    }
                    int t = w[i1][j1];
                    if (i1 != i2) {
                        t += w[i2][j2];
                    }
                    f[k][i1][i2] = Math.max(f[k][i1][i2], Math.max(
                            Math.max(f[k - 1][i1 - 1][i2], f[k - 1][i1][i2 - 1]),
                            Math.max(f[k - 1][i1 - 1][i2 - 1], f[k - 1][i1][i2])
                    ) + t);
                }
            }
        }

        out.println(f[n * 2][n][n]);

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
