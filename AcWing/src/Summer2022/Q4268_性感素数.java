package Summer2022;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/24
 */
public class Q4268_性感素数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        // 1. 能够找到性感素数的情况
        if (isPrime(n - 6) && isPrime(n)) {
            out.println("Yes");
            out.println(n - 6);
            close();
        }
        if (isPrime(n) && isPrime(n + 6)) {
            out.println("Yes");
            out.println(n + 6);
            close();
        }

        // 2. 找不到的情况：向上寻找比n大的最小的性感素数并输出
        for (int i = n + 1; ; i++) {
            if (isPrime(i) && (isPrime(i - 6) || isPrime(i + 6))) {
                out.println("No");
                out.println(i);
                close();
            }
        }
    }

    private static boolean isPrime(int x) {
        // 判断负数
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
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
        System.exit(0);
    }
}
