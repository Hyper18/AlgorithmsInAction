package Graph.ShortestPath.Single;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/02
 * <p>
 * 思路
 * 一遍AC
 * 由于题干给定最后收到的金额为100求初始金额
 * 因此从最后一个结点出发，向初始点求最短路费用
 */
public class Q1126_最小花费 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 2000 + 10, M = 100000 * 2 + 10, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static double[] d = new double[N];
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
            int a = nextInt(), b = nextInt(), c = nextInt();
            addEdge(a, b, c);
            addEdge(b, a, c);
        }
        int st = nextInt(), ed = nextInt();
        spfa(ed);
        out.printf("%.8f", d[st]);
        close();
    }

    private static void spfa(int ed) {
        Arrays.fill(d, INF);
        d[ed] = 100D;

        Queue<Integer> q = new LinkedList<>();
        q.offer(ed);
        vis[ed] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                // 本题与其他最短路问题不一样的地方
                if (d[j] > d[u] / (1 - w[i] / 100D)) {
                    d[j] = d[u] / (1 - w[i] / 100D);
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
