package train;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/08
 * @time 78ms
 */
public class ALGO_51 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 50000;

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        long ans = 1;
        int cnt = 0, num = 2;
        while (cnt < n) {
            if (isPrime(num)) {
                ans *= num % MOD;
                ans %= MOD;
                cnt++;
            }

            num++;
        }

        out.println(ans);

        close();
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
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
