package DP.Knapsack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/11
 * <p>
 * 思路
 * 求二维费用的01背包问题
 * 1. 状态表示
 * 集合：f[i][j][k]表示从前i个物品中选
 * 氧气含量至少是j并且氮气含量至少是k的所有选法的气缸重量总和的最小值
 * 属性：Min
 * 由于是求最小，小结一下 -- 一共注意两点：
 * 1）数组应先初始化为一个较大的值
 * 2）确定状态转移方程的起始状态，本题为重量，则
 * 2. 状态计算
 * f[j][k] = min(f[j][k], f[max(0, j - a)][max(0, k - b)] + c)
 */
public class Q1020_潜水员 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int M = 21 + 3, N = 79 + 3, INF = 0x3f3f3f3f;
    private static int[][] f = new int[M][N];

    public static void main(String[] args) throws IOException {
        int m = nextInt(), n = nextInt(), K = nextInt();

        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][0] = 0;
        for (int i = 0; i < K; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    f[j][k] = Math.min(f[j][k], f[Math.max(0, j - a)][Math.max(0, k - b)] + c);
                }
            }
        }

        out.println(f[m][n]);

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
