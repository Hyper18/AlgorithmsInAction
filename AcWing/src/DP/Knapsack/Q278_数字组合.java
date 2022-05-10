package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/10
 * <p>
 * 思路
 * 求01背包问题的方案数
 * <p>
 * 注：这题背包体积的数目范围最大为M=10000
 * 第一下跟N取值混淆，结果越界了
 */
public class Q278_数字组合 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10000 + 10;
    private static int[] f = new int[N], g = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        g[0] = 1;
        for (int i = 0; i < n; i++) {
            int v = nextInt();
            for (int j = m; j >= v; j--) {
                int maxV = Math.max(f[j], f[j - v] + v);
                int cnt = 0;
                if (maxV == f[j]) {
                    cnt += g[j];
                }
                if (maxV == f[j - v] + v) {
                    cnt += g[j - v];
                }
                g[j] = cnt;
                f[j] = maxV;
            }
        }

        int maxV = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i <= m; i++) {
            maxV = Math.max(maxV, f[i]);
        }
        for (int i = 0; i <= m; i++) {
            if (maxV == f[i]) {
                ans += g[i];
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
