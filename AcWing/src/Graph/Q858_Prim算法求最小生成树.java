package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/30
 */
public class Q858_Prim算法求最小生成树 {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tk = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, INF = 0x3f3f3f3f;
    private static int[][] g = new int[N][N];
    private static int[] d = new int[N];
    private static boolean[] vis = new boolean[N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int ans = prim();
        out.println(ans == INF ? "impossible" : ans);
        close();
    }

    private static int prim() {
        Arrays.fill(d, INF);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (t == -1 || d[t] > d[j])) {
                    t = j;
                }
            }
            if (i != 0 && d[t] == INF) {
                return INF;
            }
            if (i != 0) {
                ans += d[t];
            }
            vis[t] = true;
            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], g[t][j]);
            }
        }

        return ans;
    }

    private static int nextInt() throws IOException {
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
