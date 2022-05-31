package DS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/31
 */
public class Q837_连通块中点的数量 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10;
    private static int[] p = new int[N], cnt = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            cnt[i]++;
        }
        while (m-- > 0) {
            String op = next();
            int a = nextInt();
            if ("C".equals(op)) {
                int b = nextInt();
                int p1 = find(a), p2 = find(b);
                if (p1 != p2) {
                    p[p1] = p2;
                    cnt[p2] += cnt[p1];
                }
            } else if ("Q1".equals(op)) {
                int b = nextInt();
                out.println(find(a) == find(b) ? "Yes" : "No");
            } else {
                out.println(cnt[find(a)]);
            }
        }
        close();
    }

    private static int find(int x) {
        if (x != p[x]) {
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
