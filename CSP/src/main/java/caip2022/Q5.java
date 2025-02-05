package caip2022;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/07/10
 */
public class Q5 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000000 + 10;
    private static int[] cnt = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i < n; i++) {
            cnt[nextInt()]++;
            cnt[nextInt()]++;
        }

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 1) {
                ans++;
            }
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
