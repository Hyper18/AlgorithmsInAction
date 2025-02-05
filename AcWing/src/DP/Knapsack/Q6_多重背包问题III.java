package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/18
 * <p>
 * 多重背包问题的单调队列优化
 * <p>
 * 待回看
 */
public class Q6_多重背包问题III {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 20000 + 10;
    private static int[] f = new int[N], g = new int[N];
    private static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        for (int i = 0; i < n; i++) {
            int v = nextInt(), w = nextInt(), s = nextInt();
            System.arraycopy(f, 0, g, 0, f.length);
            for (int j = 0; j < v; j++) {
                int hh = 0, tt = -1;
                for (int k = j; k <= m; k += v) {
                    if (hh <= tt && q[hh] < k - s * v) {
                        hh++;
                    }
                    while (hh <= tt && g[q[tt]] - (q[tt] - j) / v * w <= g[k] - (k - j) / v * w) {
                        tt--;
                    }
                    q[++tt] = k;
                    f[k] = g[q[hh]] + (k - q[hh]) / v * w;
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
