package Graph.ShortestPath.Single;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/01
 * 使用内置API的写法
 */
public class Q1129_热浪_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 2500 + 10, M = 6200 * 2 + 10, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
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
        int n = nextInt(), m = nextInt(), st = nextInt(), ed = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            addEdge(a, b, c);
            addEdge(b, a, c);
        }
        spfa(st);
        out.println(d[ed]);
        close();
    }

    private static void spfa(int st) {
        Arrays.fill(d, INF);
        d[st] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(st);
        vis[st] = true;
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
