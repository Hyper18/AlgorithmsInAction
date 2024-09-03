package Fundamentals.Combination;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/23
 * @file Q885_求组合数I.java
 */
public class Q885_求组合数I {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int N = 2010, MOD = (int) 1e9 + 7;
    static int[][] c = new int[N][N];

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(), b = nextInt();
            out.println(c[a][b]);
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
