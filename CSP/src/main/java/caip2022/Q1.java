package caip2022;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/07/10
 */
public class Q1 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1010;
    private static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + a[i] > m) {
                ans++;
                sum = 0;
            }
            sum += a[i];
        }

        out.println(ans);

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
