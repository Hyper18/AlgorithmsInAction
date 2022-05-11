package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/11
 * <p>
 * 注：没考虑数据量上限WA了，实际会爆int
 * 本题的数据量规模：
 * 思路 求完全背包的方案数
 * 1. 状态表示
 * 集合：f[i][j]表示考虑钱数为i时，且面值和为jj的集合下能获得的方案数
 * 属性：cnt
 * 2. 状态计算
 * 同Q1023
 */
public class Q1021_货币系统 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 3000 + 10;
    private static long[] f = new long[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        f[0] = 1;
        for (int i = 0; i < n; i++) {
            int v = nextInt();
            for (int j = v; j <= m; j++) {
                f[j] += f[j - v];
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
