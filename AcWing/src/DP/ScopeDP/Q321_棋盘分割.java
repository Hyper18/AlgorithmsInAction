package DP.ScopeDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/24
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：将(x1, y1)(x2, y2)所表示的子矩阵切分为k个部分的所有方案
 * 属性：min均方差
 * 2. 状态计算
 * 1）纵切
 * f[x1][y1][x2][y2][k] = min(f[x1][y1][x2][y2][k], get(x1, y1, i, y2) + dp(i + 1, y1, x2, y2, k - 1))
 * f[x1][y1][x2][y2][k] = min(f[x1][y1][x2][y2][k], get(i + 1, y1, x2, y2) + dp(x1, y1, i, y2, k - 1))
 * 2）横切
 * f[x1][y1][x2][y2][k] = min(f[x1][y1][x2][y2][k], get(x1, y1, x2, i) + dp(x1, i + 1, x2, y2, k - 1))
 * f[x1][y1][x2][y2][k] = min(f[x1][y1][x2][y2][k], get(x1, i + 1, x2, y2) + dp(x1, y1, x2, i, k - 1))
 */
public class Q321_棋盘分割 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 15, M = 9;
    private static final double INF = 1e9;
    private static int[][] pre = new int[M][M];
    private static double[][][][][] f = new double[M][M][M][M][N];
    static int n, m = 8;
    static double X;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = nextInt();
                pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }

        X = (double) pre[m][m] / n;
        init();
        out.printf("%.3f\n", Math.sqrt(dp(1, 1, m, m, n)));

        close();
    }

    private static double dp(int x1, int y1, int x2, int y2, int k) {
        // 记忆化搜索：若已算过则直接返回
        if (f[x1][y1][x2][y2][k] >= 0) {
            return f[x1][y1][x2][y2][k];
        }
        if (k == 1) {
            return f[x1][y1][x2][y2][k] = get(x1, y1, x2, y2);
        }

        f[x1][y1][x2][y2][k] = INF;
        for (int i = x1; i < x2; i++) {
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(x1, y1, i, y2) + dp(i + 1, y1, x2, y2, k - 1));
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(i + 1, y1, x2, y2) + dp(x1, y1, i, y2, k - 1));
        }
        for (int i = y1; i < y2; i++) {
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(x1, y1, x2, i) + dp(x1, i + 1, x2, y2, k - 1));
            f[x1][y1][x2][y2][k] = Math.min(f[x1][y1][x2][y2][k], get(x1, i + 1, x2, y2) + dp(x1, y1, x2, i, k - 1));
        }

        return f[x1][y1][x2][y2][k];
    }

    private static double get(int x1, int y1, int x2, int y2) {
        double sum = pre[x2][y2] - pre[x2][y1 - 1] - pre[x1 - 1][y2] + pre[x1 - 1][y1 - 1] - X;
        return sum * sum / n;
    }

    private static void init() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        Arrays.fill(f[i][j][k][l], -INF);
                    }
                }
            }
        }
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
