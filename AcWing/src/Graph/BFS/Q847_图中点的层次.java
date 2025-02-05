package Graph.BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/29
 * <p>
 * 思路
 * 图论中最短路的求法：
 * 1. Dijkstra
 * 2. Floyd
 * 3. SPFA
 */
public class Q847_图中点的层次 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10;
    private static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N];
    static int n, m, idx;

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            addEdge(nextInt(), nextInt());
        }
        out.println(bfs());
        close();
    }

    private static int bfs() {
        // 根据题意，当找不到最短路径时，默认应返回-1
        Arrays.fill(d, -1);
        d[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int u = q.poll();

            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] != -1) {
                    continue;
                }
                d[j] = d[u] + 1;
                q.offer(j);
            }
        }

        // 从编号为1的结点~n号结点的最短距离
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
