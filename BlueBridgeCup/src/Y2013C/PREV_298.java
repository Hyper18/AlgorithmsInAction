package Y2013C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/16
 * @time 125ms
 * 转化为找到三个数的最小公倍数
 */
public class PREV_298 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        int ans = lcm(a, b);
        ans = lcm(ans, c);

        out.println(ans);

        close();
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
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
