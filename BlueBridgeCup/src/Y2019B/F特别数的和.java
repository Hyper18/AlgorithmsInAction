package Y2019B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * @time 109ms
 * 一遍AC
 */
public class F特别数的和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                ans += (long) i;
            }
        }

        out.println(ans);

        close();
    }

    private static boolean check(int n) {
        String s = String.valueOf(n);
        if (s.charAt(0) == '0') {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c == '2' || c == '0' || c == '1' || c == '9') {
                return true;
            }
        }
        return false;
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
