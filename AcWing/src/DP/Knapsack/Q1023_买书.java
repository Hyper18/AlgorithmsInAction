package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/11
 * <p>
 * 思路
 * 完全背包问题求方案数
 * 1. 状态表示
 * 集合：f[i][j] 表示考虑钱数为i时，且总数字和恰好j的集合下能获得的方案数
 * 属性：cnt
 * 2. 状态计算
 * 1）选取第i个数 f[i][j] = f[i][j - v[i]]
 * 2）不选第i个数 f[i][j] = f[i - 1][j]
 */
public class Q1023_买书 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static final int[] v = new int[]{0, 10, 20, 50, 100};
    private static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = v.length, m = nextInt();
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = v[i]; j <= m; j++) {
                f[j] = f[j] + f[j - v[i]];
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
