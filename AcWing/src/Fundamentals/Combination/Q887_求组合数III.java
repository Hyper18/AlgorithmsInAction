package Fundamentals.Combination;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/26
 * @file Q887_求组合数III.java
 */
public class Q887_求组合数III {
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

    private static int C(long a, long b, int p) {
        if (b > a) {
            return 0;
        }

        int ans = 1;
        for (int i = 1, j = (int) a; i <= b; i++, j--) {
            ans = Math.toIntExact((long) ans * j % p);
            ans = Math.toIntExact((long) ans * qmi(i, p - 2, p) % p);
        }

        return ans;
    }

    private static int lucas(long a, long b, int p) {
        if (a < p && b < p) {
            return C(a, b, p);
        }
        return Math.toIntExact((long) C(a % p, b % p, p) * lucas(a / p, b / p, p) % p);
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (n-- > 0) {
            long a = nextLong(), b = nextLong();
            int p = nextInt();
            out.println(lucas(a, b, p));
        }

        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static long nextLong() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Long.parseLong(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
