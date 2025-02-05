package DP.CountDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/06
 * <p>
 * 思路 完全背包
 * 1. 状态表示
 * 集合：从1~i中选，体积恰为j的选法数量
 * 属性：数目
 * 2. 状态计算
 * f[i][j] = f[i - 1][j] + f[i][j - i]
 */
public class Q900_整数划分 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 1000000000 + 7;
    private static final int N = 1000 + 10;
    private static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        // 初始化：都不选也可作为一种方案
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                // 降维
                f[j] = (f[j] + f[j - i]) % MOD;
            }
        }
        out.println(f[n]);
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
