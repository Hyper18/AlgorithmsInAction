package Fundamentals.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/06
 */
public class Q2816_判断子序列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N], b = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = nextInt();
        }

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                p1++;
            }
            p2++;
        }

        out.println(p1 == n ? "Yes" : "No");

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
