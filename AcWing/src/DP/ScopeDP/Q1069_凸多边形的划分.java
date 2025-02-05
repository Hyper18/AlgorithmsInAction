package DP.ScopeDP;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/23
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：f[i][j]表示所有将(L，L+1),(L+1,L+2)，... (R-1，R)，(R,L)这个多边形划分成三角形的方案
 * 属性：min
 * 2. 状态计算
 * f[l][r] = max(f[l][r], f[l][k] + f[k][r] + a[l] * a[k] * a[r])
 * <p>
 * 注：此题需要使用高精度处理
 * 待回看
 */
public class Q1069_凸多边形的划分 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 50 + 5;
    private static final String INF = "10000000000000000000000000000000";
    private static int[] w = new int[N];
    private static BigInteger[][] f = new BigInteger[N][N];
    private static final BigInteger ZERO = BigInteger.ZERO;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }

        for (int i = 1; i + 1 <= n; i++) {
            int j = i + 1;
            f[i][j] = ZERO;
        }
        for (int len = 3; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                BigInteger a = BigInteger.valueOf(w[l]);
                BigInteger b = BigInteger.valueOf(w[r]);
                f[l][r] = new BigInteger(INF);
                for (int k = l + 1; k < r; k++) {
                    BigInteger c = BigInteger.valueOf(w[k]);
                    BigInteger s = a.multiply(b).multiply(c);
                    BigInteger t = f[l][k].add(f[k][r]).add(s);
                    f[l][r] = f[l][r].min(t);
                }
            }
        }

        out.println(f[1][n]);

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
