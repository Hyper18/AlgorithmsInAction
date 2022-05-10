package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/10
 * <p>
 * 思路 01背包问题 -- O(n^2)
 * 1. 状态表示
 * 集合：f[j]表示当箱子的体积为j时，物品所能占用的最大体积
 * 属性：Max
 * 2. 状态计算
 * f[j] = max(f[j], f[j - v] + v)
 */
public class Q1024_装箱问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 20000 + 10;
    private static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int m = nextInt(), n = nextInt();
        for (int i = 1; i <= n; i++) {
            int v = nextInt();
            for (int j = m; j >= v; j--) {
                f[j] = Math.max(f[j], f[j - v] + v);
            }
        }
        out.println(m - f[m]);
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
