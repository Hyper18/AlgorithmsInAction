package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * @time 78ms
 * 贪心 快速幂
 */
public class E_算法训练_数的潜能 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 5218;

    public static void main(String[] args) throws IOException {
        long n = nextLong();
        long m = n / 3;
        long h = n % 3;

        if (m > 0 && h == 1) {
            m--;
            h = 4;
        }
        long sum = pow(3, m);
        if (h != 0) {
            sum *= h;
            sum %= MOD;
        }

        out.println(sum);

        close();
    }

    private static long pow(long base, long p) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                res *= base;
                res %= MOD;
            }
            p /= 2;
            base = (base * base) % MOD;
        }

        return res;
    }

    private static long nextLong() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }
        return Long.parseLong(token.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
