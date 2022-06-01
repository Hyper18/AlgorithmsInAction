package Graph.ShortestPath.Single;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/01
 */
public class Q1129_热浪 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    /**
     * 无向图的邻接表存储开 2倍
     */
    private static final int N = 2500 + 10, M = 6200 * 2 + 10, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static int[] d = new int[N], q = new int[N];
    private static boolean[] vis = new boolean[N];
    static int idx;

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        // 做完后实际发现没有用到入参n
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

        int hh = 0, tt = 1;
        q[0] = st;
        vis[st] = true;
        while (hh != tt) {
            int u = q[hh++];
            // 模拟循环队列，当一维数组到达末址后返回首址
            if (hh == N) {
                hh = 0;
            }
            vis[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > d[u] + w[i]) {
                    d[j] = d[u] + w[i];
                    if (vis[j]) {
                        continue;
                    }
                    vis[j] = true;
                    // 注意控制先入队在递增指针，防止数组越界
                    q[tt++] = j;
                    if (tt == N) {
                        tt = 0;
                    }
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
