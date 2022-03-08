package practice4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * @time 140ms
 */
public class F_算法提高_Torry的困惑提高型 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAXN = 10000000 + 5;
    private static final int MOD = 50000;
    private static boolean[] isPrime = new boolean[MAXN];
    private static int[] prime = new int[MAXN];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        getPrime(10000000);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= prime[i] % MOD;
            ans %= MOD;
        }
        out.println(ans);

        close();
    }

    private static void getPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                prime[cnt++] = i;
            }
            for (int j = 0; j < cnt && i * prime[j] <= n; j++) {
                isPrime[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
