package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/18
 * 混合背包问题
 * <p>
 * 思路 -- 方案二
 * 1. 先处理完全背包
 * 2. 将01背包视作多重背包一起处理
 */
public class Q7_混合背包问题_2 {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        for (int i = 0; i < n; i++) {
            int v = nextInt(), w = nextInt(), s = nextInt();
            if (s == 0) {
                for (int j = v; j <= m; j++) {
                    f[j] = Math.max(f[j], f[j - v] + w);
                }
            } else {
                if (s == -1) {
                    s = 1;
                }
                for (int k = 1; k <= s; k <<= 1) {
                    for (int j = m; j >= k * v; j--) {
                        f[j] = Math.max(f[j], f[j - k * v] + k * w);
                    }
                    s -= k;
                }
                if (s != 0) {
                    for (int j = m; j >= s * v; j--) {
                        f[j] = Math.max(f[j], f[j - s * v] + s * w);
                    }
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