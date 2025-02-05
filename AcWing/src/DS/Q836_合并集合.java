package DS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/31
 */
public class Q836_合并集合 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10;
    private static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m-- > 0) {
            String op = next();
            int a = nextInt(), b = nextInt();
            if ("M".equals(op)) {
                int p1 = find(a), p2 = find(b);
                p[p1] = p2;
            } else {
                out.println(find(a) == find(b) ? "Yes" : "No");
            }
        }
        close();
    }

    private static int find(int x) {
        // 上溯
        if (p[x] != x) {
            // x = find(p[x]);
            // 对比：上式也是正确的。下式减少自调用次数，降低了时间复杂度
            p[x] = find(p[x]);
        }
        return p[x];
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
