package Fundamentals.PreSum;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/03
 */
public class Q795_前缀和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] pre = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        // 初始化前缀和
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nextInt();
        }

        while (m-- > 0) {
            int l = nextInt(), r = nextInt();
            // 计算区间和
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
