package Graph.ShortestPath.Single;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/03
 * <p>
 * 思路
 * 非标准的bfs
 * 可以理解为简化版的求最短路问题，
 * 即使用朴素Dijkstra求解
 * 也可以考虑使用Floyd
 * <p>
 * 注：本题主要操作集中在处理输入上（特别是C++）
 */
public class Q920_最优乘车 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, INF = 0x3f3f3f3f;
    private static boolean[][] g = new boolean[N][N];
    private static int[] d = new int[N];

    public static void main(String[] args) throws IOException {
        // 注意输入次序
        int m = nextInt(), n = nextInt();
        while (m-- > 0) {
            String[] input = in.readLine().split(" ");
            int len = input.length;
            int[] st = new int[len];
            for (int i = 0; i < len; i++) {
                st[i] = Integer.parseInt(input[i]);
            }
            // 标记所有可相互访问的站点（可达）
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    g[st[i]][st[j]] = true;
                }
            }
        }
        bfs(n);
        // 注意这里输出的是换乘次数，不是乘车次数
        out.println(d[n] == INF ? "NO" : d[n] - 1);
        close();
    }

    private static void bfs(int n) {
        Arrays.fill(d, INF);
        d[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!g[u][i]) {
                    continue;
                }
                if (d[i] > d[u] + 1) {
                    d[i] = d[u] + 1;
                    q.offer(i);
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
