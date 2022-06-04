package Graph.ShortestPath.Single;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/04
 */
public class Q903_昂贵的聘礼 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10, M = (int) 1e4 + 10, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static int[] d = new int[N], level = new int[N];
    private static boolean[] vis = new boolean[N];
    static int m, n, idx;

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        m = nextInt();
        n = nextInt();
        Arrays.fill(h, -1);
        for (int i = 1; i <= n; i++) {
            int price = nextInt();
            level[i] = nextInt();
            int cnt = nextInt();
            // 0号点花费price的价值就可以买
            addEdge(0, i, price);
            while (cnt-- > 0) {
                int j = nextInt(), value = nextInt();
                // j-->i 有编号为j的替代品，则花费value即可买下i
                addEdge(j, i, value);
            }
        }
        int ans = INF;
        // 从地位限制差距的下边界开始，往上边界遍历
        for (int i = level[1] - m; i <= level[1]; i++) {
            // 和区间[i, i + m]内的人做交易
            spfa(i, i + m);
            ans = Math.min(ans, d[1]);
        }
        out.println(ans);
        close();
    }

    private static void spfa(int l, int r) {
        Arrays.fill(d, INF);
        d[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                // 额外的限制条件：交换双方的身份差
                if (l <= level[j] && level[j] <= r && d[j] > d[u] + w[i]) {
                    d[j] = d[u] + w[i];
                    if (vis[j]) {
                        continue;
                    }
                    vis[j] = true;
                    q.offer(j);
                }
            }
        }
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
