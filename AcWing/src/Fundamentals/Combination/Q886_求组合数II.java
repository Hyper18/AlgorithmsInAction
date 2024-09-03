package Fundamentals.Combination;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/25
 * @file Q886_求组合数II.java
 */
public class Q886_求组合数II {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int N = 100010, MOD = (int) 1e9 + 7;
    static long[] fact = new long[N], infact = new long[N];

    private static void init() {
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
            infact[i] = infact[i - 1] * qmi(i, MOD - 2, MOD) % MOD;
        }
    }

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
        init();
        int n = nextInt();
        while (n-- > 0) {
            int a = nextInt(), b = nextInt();
            out.println(fact[a] * infact[a - b] % MOD * infact[b] % MOD);
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
