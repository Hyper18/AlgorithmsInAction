package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/30
 */
public class Q851_spfa求最短路 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    private static int[] d = new int[N];
    private static boolean[] vis = new boolean[N];
    static int n, m, idx;

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            addEdge(nextInt(), nextInt(), nextInt());
        }
        int ans = spfa();
        out.println(ans == INF ? "impossible" : ans);
        close();
    }

    private static int spfa() {
        Arrays.fill(d, INF);
        d[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;

            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > d[u] + w[i]) {
                    d[j] = d[u] + w[i];
                    if (vis[j]) {
                        continue;
                    }
                    q.offer(j);
                    vis[j] = true;
                }
            }
        }

        return d[n];
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
