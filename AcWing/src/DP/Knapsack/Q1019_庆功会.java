package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/12
 * <p>
 * 思路 多重背包问题
 * 1. 状态表示
 * 集合：f[i][j]表示考虑前i个物品，背包体积为j时所能获取的最大价值
 * 属性：Max
 * 2. 状态计算
 * f[j] = max(f[j], f[j - k * v] + k * w)
 */
public class Q1019_庆功会 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 6000 + 10;
    private static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 0; i < n; i++) {
            int v = nextInt(), w = nextInt(), s = nextInt();
            for (int j = m; j >= v; j--) {
                for (int k = 1; k <= s && k * v <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v] + k * w);
                }
            }
        }
        out.println(f[m]);
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
