package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/10
 * <p>
 * 需要注意两个问题：
 * 1. 初始化：
 * g[0]都不选也可作为一种方案
 * 2. 求得的Max未必就是f[m]
 */
public class Q11_背包问题求方案数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10, MOD = 1000000000 + 7;
    private static final int[] f = new int[N], g = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        g[0] = 1;
        for (int i = 0; i < n; i++) {
            int v = nextInt(), w = nextInt();
            for (int j = m; j >= v; j--) {
                int maxV = Math.max(f[j], f[j - v] + w);
                int cnt = 0;
                if (maxV == f[j]) {
                    cnt += g[j];
                }
                if (maxV == f[j - v] + w) {
                    cnt += g[j - v];
                }
                g[j] = cnt % MOD;
                f[j] = maxV;
            }
        }

        int max = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i <= m; i++) {
            max = Math.max(max, f[i]);
        }
        for (int i = 0; i <= m; i++) {
            if (f[i] == max) {
                ans = (ans + g[i]) % MOD;
            }
        }
        out.println(ans);

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
