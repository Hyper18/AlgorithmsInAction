package Fundamentals.QuickPow;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/25
 * @file Q875_快速幂.java
 */
public class Q875_快速幂 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private static long qmi(int a, int k, int p) {
        long ans = 1 % p, t = a;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = ans * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(), b = nextInt(), p = nextInt();
            out.println(qmi(a, b, p));
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
