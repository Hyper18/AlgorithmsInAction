package Fundamentals.BitOp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 */
public class Q801_二进制中1的个数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (n-- > 0) {
            int ans = 0, x = nextInt();
            while (x > 0) {
                x -= lowbit(x);
                ans++;
            }
            out.print(ans + " ");
        }
        close();
    }

    private static int lowbit(int x) {
        return x & -x;
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
