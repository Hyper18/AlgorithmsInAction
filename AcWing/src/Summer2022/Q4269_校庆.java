package Summer2022;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/24
 */
public class Q4269_校庆 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10;
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            set.add(next());
        }
        int m = nextInt();
        int ans = 0;
        String a = "", b = "";
        for (int i = 1; i <= m; i++) {
            String in = next();
            if (set.contains(in)) {
                ans++;
                if (a.isEmpty() || Integer.parseInt(a.substring(6, 14)) > Integer.parseInt(in.substring(6, 14))) {
                    a = in;
                }
            }
            if (b.isEmpty() || Integer.parseInt(b.substring(6, 14)) > Integer.parseInt(in.substring(6, 14))) {
                b = in;
            }
        }
        out.println(ans);
        out.println(ans > 0 ? a : b);
        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static String next() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
