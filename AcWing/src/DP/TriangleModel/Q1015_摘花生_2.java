package DP.TriangleModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/08
 * 思路 dp
 * 1. 状态表示
 * 集合：f[i][j] 走到第i行第j个为之能获取的最大数目
 * 属性：Max
 * 2. 状态计算
 * f[i][j] = max(f[i - 1][j], f[i][j - 1]) + w[i][j]
 */
public class Q1015_摘花生_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10;
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (n-- > 0) {
            int r = nextInt(), c = nextInt();
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + nextInt();
                }
            }
            out.println(f[r][c]);
        }
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
