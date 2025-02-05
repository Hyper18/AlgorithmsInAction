package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/30
 */
public class Q850_Dijkstra求最短路II {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1.5e5 + 10, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    private static int[] d = new int[N];
    private static boolean[] vis = new boolean[N];
    static int idx;

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            addEdge(nextInt(), nextInt(), nextInt());
        }
        out.println(dijkstra(n));
        close();
    }

    private static int dijkstra(int n) {
        Arrays.fill(d, INF);
        d[1] = 0;

        // 创建一个处事容量为n的优先队列，其排列次序按照升序排列
        PriorityQueue<int[]> q = new PriorityQueue<>(n, Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int u = pos[0], dis = pos[1];
            if (vis[u]) {
                continue;
            }
            vis[u] = true;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + w[i]) {
                    d[j] = dis + w[i];
                }
                q.offer(new int[]{j, d[j]});
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
