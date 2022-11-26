package Algorithm_BasicLevel.Math.Combination;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/26
 * @file Q888_求组合数IV.java
 */
public class Q888_求组合数IV {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int N = 5010;
    static int[] primes = new int[N], sum = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt;

    static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }

    /**
     * 求n个阶乘中包含的p的个数
     */
    static int get(int n, int p) {
        int ans = 0;
        while (n > 0) {
            ans += n / p;
            n /= p;
        }

        return ans;
    }

    /**
     * 高精度乘法
     */
    static List<Integer> mul(List<Integer> a, int b) {
        List<Integer> c = new ArrayList<>();
        int t = 0;
        for (int i : a) {
            t += i * b;
            c.add(t % 10);
            t /= 10;
        }
        while (t > 0) {
            c.add(t % 10);
            t /= 10;
        }

        return c;
    }

    public static void main(String[] args) throws IOException {
        int a = nextInt(), b = nextInt();

        getPrimes(a);
        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            sum[i] = get(a, p) - get(a - b, p) - get(b, p);
        }

        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < sum[i]; j++) {
                res = mul(res, primes[i]);
            }
        }

        for (int i = res.size() - 1; i >= 0; i--) {
            out.print(res.get(i));
        }
        out.println();

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
