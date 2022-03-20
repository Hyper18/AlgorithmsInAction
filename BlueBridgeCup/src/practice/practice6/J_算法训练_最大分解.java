package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * @time 93ms
 * 贪心法
 * <p>
 * 注意不算首项
 */
public class J_算法训练_最大分解 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        int ans = 0;
        int next = n - 1;
        while (n > 1) {
            if (n % next == 0) {
                ans += next;
                n = next;
                next = n - 1;
            } else {
                next--;
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
