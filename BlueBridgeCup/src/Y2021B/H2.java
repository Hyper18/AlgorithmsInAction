package Y2021B;

import java.io.*;
import java.util.StringTokenizer;

public class H2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 44721 + 4;

    public static void main(String[] args) throws IOException {
        long n = nextLong();
        long[] arr = new long[MAX];
        arr[0] = 1;
        long k = 1L;
        if (n == 1) {
            out.println(1);
            return;
        }

        for (int i = 1; i < MAX; i++) {
            // 使用历史状态
            for (int j = i; j >= 1; j--) {
                arr[j] += arr[j - 1];
                if (arr[j] == n) {
                    out.println(k + i - j + 1);
                    return;
                }
            }
            k += (i + 1);
        }

        out.println((n * (n + 1) / 2) + 2);

        close();
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
