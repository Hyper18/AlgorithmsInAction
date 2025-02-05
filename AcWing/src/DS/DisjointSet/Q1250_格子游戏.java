package DS.DisjointSet;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/15
 */
public class Q1250_格子游戏 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 200 * 200 + 10;
    private static int[] p = new int[N];
    static int n, m, ans;

    private static int get(int x, int y) {
        return x * n + y;
    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n * n; i++) {
            p[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int x = nextInt(), y = nextInt();
            char d = next().charAt(0);
            x -= 1;
            y -= 1;

            int a = get(x, y), b = d == 'D' ? get(x + 1, y) : get(x, y + 1);
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                ans = i;
                break;
            }
            p[pa] = pb;
        }
        out.println(ans == 0 ? "draw" : ans);
        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static String next() throws IOException {
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
