package DP.ScopeDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/23
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：
 * f[l][r]表示所有将[l,r]合并成一堆石子的最小区间和
 * g[l][r]表示所有将[l,r]合并成一堆石子的最大区间和
 * 属性：min、max
 * 2. 状态计算
 * f[l][r] = min(f[l][r], f[l][k] + f[k + 1][r] + pre[r] - pre[l - 1])
 * g[l][r] = max(g[l][r], g[l][k] + g[k + 1][r] + pre[r] - pre[l - 1])
 * <p>
 * 采用前缀和求总和，再分别求区间和
 */
public class Q1068_环形石子合并 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 200 * 2 + 10, INF = 0x3f3f3f3f;
    private static int[] a = new int[N], pre = new int[N];
    private static int[][] f = new int[N][N], g = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = a[i + n] = nextInt();
        }
        for (int i = 1; i <= n * 2; i++) {
            pre[i] = pre[i - 1] + a[i];
        }

        for (int i = 0; i <= n * 2; i++) {
            for (int j = 0; j <= n * 2; j++) {
                f[i][j] = INF;
                g[i][j] = -INF;
            }
        }
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n * 2; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    f[l][r] = g[l][r] = 0;
                } else {
                    for (int k = l; k < r; k++) {
                        f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + pre[r] - pre[l - 1]);
                        g[l][r] = Math.max(g[l][r], g[l][k] + g[k + 1][r] + pre[r] - pre[l - 1]);
                    }
                }
            }
        }

        int min = INF, max = -INF;
        for (int l = 1; l <= n; l++) {
            int r = l + n - 1;
            if (f[l][r] < min) {
                min = f[l][r];
            }
            if (g[l][r] > max) {
                max = g[l][r];
            }
        }
        out.printf("%d\n%d", min, max);

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
