package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/29
 */
public class Q849_Dijkstra求最短路I {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, INF = 0x3f3f3f3f;
    private static int[][] g = new int[N][N];
    private static int[] d = new int[N];
    private static boolean[] vis = new boolean[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }
        out.println(dijkstra(n));
        close();
    }

    private static int dijkstra(int n) {
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (t == -1 || d[t] > d[j])) {
                    t = j;
                }
            }

            vis[t] = true;
            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }
        }

        return d[n] == INF ? -1 : d[n];
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
