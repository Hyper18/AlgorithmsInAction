package DP.LinearDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/04
 */
public class Q895_最长上升子序列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] a = new int[N], f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        out.println(Arrays.stream(f).max().getAsInt());

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
