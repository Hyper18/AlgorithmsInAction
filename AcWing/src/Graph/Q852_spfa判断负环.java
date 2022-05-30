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
public class Q852_spfa判断负环 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 2000 + 10, M = (int) 1e4 + 10;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static int[] d = new int[N], cnt = new int[N];
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
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            addEdge(a, b, c);
        }
        out.println(spfa() ? "Yes" : "No");
        close();
    }

    private static boolean spfa() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
            vis[i] = true;
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;

            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > d[u] + w[i]) {
                    d[j] = d[u] + w[i];
                    cnt[j] = cnt[u] + 1;
                    if (cnt[j] >= n) {
                        return true;
                    }
                    if (vis[j]) {
                        continue;
                    }
                    q.offer(j);
                    vis[j] = true;
                }
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
