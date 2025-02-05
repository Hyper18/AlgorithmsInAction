package DP.ScopeDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/23
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：f[l][r]表示所有将[l, r]合并成一个珠子的方式
 * 属性：max
 * 2. 状态计算
 * f[l][r] = max(f[l][r], f[l][k] + f[k][r] + a[l] * a[k] * a[r])
 */
public class Q320_能量项链 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 * 2 + 5;
    private static int[] a = new int[N];
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = a[i + n] = nextInt();
        }

        for (int len = 3; len <= n + 1; len++) {
            for (int l = 1; l + len - 1 <= n * 2; l++) {
                int r = l + len - 1;
                for (int k = l + 1; k < r; k++) {
                    f[l][r] = Math.max(f[l][r], f[l][k] + f[k][r] + a[l] * a[k] * a[r]);
                }
            }
        }

        int max = 0;
        for (int l = 1; l <= n; l++) {
            int r = l + n;
            if (f[l][r] > max) {
                max = f[l][r];
            }
        }
        out.println(max);

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
