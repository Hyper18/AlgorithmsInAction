package DP.LinearDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/04
 * <p>
 * 思路
 * 1. 状态表示 = 从左上来 / 从右上来
 * 2. 状态计算 ：f[i][j] = max(f[i - 1][j], f[i - 1][j - 1]) + a[i][j]
 */
public class Q898_数字三角形 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, INF = 0x3f3f3f3f;
    private static int[][] a = new int[N][N], f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = nextInt();
            }
        }

        // 处理边界条件，防止越界
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i + 1; j++) {
                f[i][j] = -INF;
            }
        }

        f[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1]) + a[i][j];
            }
        }

        int res = -INF;
        // 这里需要控制输出，否则当结果为负数时，读入的最大值为没有使用到的数组位置，在java中默认为0
        for (int i = 1; i <= n; i++) {
            if (f[n][i] > res) {
                res = f[n][i];
            }
        }
        out.println(res);

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
