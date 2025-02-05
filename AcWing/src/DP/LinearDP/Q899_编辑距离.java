package DP.LinearDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/05
 */
public class Q899_编辑距离 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10 + 3, M = 1000 + 10;
    private static final char[][] s = new char[M][N];
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 0; i < n; i++) {
            s[i] = next().toCharArray();
        }

        while (m-- > 0) {
            char[] q = next().toCharArray();
            int limit = nextInt();

            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (editDistance(s[i], q) <= limit) {
                    ans++;
                }
            }
            out.println(ans);
        }

        close();
    }

    private static int editDistance(char[] a, char[] b) {
        int n = a.length, m = b.length;
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }
        return f[n][m];
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static String next() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
