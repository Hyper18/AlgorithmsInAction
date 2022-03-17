package Y2014A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/16
 * 20/100
 * 前缀和+dp
 * 数据量过大用前缀和很慢。。
 */
public class PREV_317 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 10000;
    private static long[] pre = new long[MAX + 5];

    public static void main(String[] args) throws IOException {
        long n = nextLong();
        long m = nextLong();
        long p = nextLong();

        for (int i = 1; i <= MAX; i++) {
            pre[i] = (pre[i - 1] + f(i)) % f(m);
        }

        out.println(pre[Math.toIntExact(n)] % p);

        close();
    }

    private static long f(long n) {
        if (n < 1) {
            return 0;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = pre + curr;
            pre = curr;
            curr = tmp;
        }

        return curr;
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }

    public static long nextLong() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Long.parseLong(token.nextToken());
    }
}
