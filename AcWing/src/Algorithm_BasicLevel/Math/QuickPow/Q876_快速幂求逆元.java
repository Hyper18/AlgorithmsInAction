package Algorithm_BasicLevel.Math.QuickPow;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/25
 * @file Q876_快速幂求逆元.java
 * 快速幂的应用
 */
public class Q876_快速幂求逆元 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private static long qmi(int a, int k, int p) {
        long ans = 1, t = a;
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
            int a = nextInt(), p = nextInt();
            if (a % p == 0) {
                out.println("impossible");
            } else {
                out.println(qmi(a, p - 2, p));
            }
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
