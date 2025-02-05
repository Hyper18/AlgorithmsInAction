package DS.DisjointSet;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/15
 * <p>
 * 思路
 * 并查集 + 01背包
 */
public class Q1252_搭配购买 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10000 + 10;
    private static int[] p = new int[N], v = new int[N], w = new int[N];
    private static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt(), q = nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            v[i] = nextInt();
            w[i] = nextInt();
        }
        while (m-- > 0) {
            int a = nextInt(), b = nextInt();
            int pa = find(a), pb = find(b);
            if (pa != pb) {
                v[pb] += v[pa];
                w[pb] += w[pa];
                p[pa] = pb;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (p[i] != i) {
                continue;
            }
            for (int j = q; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        out.println(f[q]);

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

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
