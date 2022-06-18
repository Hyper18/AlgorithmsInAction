package Y2021BFinal;

import java.io.*;
import java.util.StringTokenizer;

public class F_123 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e7 + 10;
    private static long[] pre = new long[N];

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int i = 1; i <= 1000000; i += cnt) {
            int base = 1;
            for (int j = i; j < i + i; j++) {
                pre[j] = pre[j - 1] + base++;
            }
            cnt++;
        }
        int t = nextInt();
        while (t-- > 0) {
            int l = nextInt(), r = nextInt();
            out.println(pre[r] - pre[l - 1]);
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
