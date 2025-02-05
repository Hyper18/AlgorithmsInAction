package Graph.BFS.Model;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/06
 * <p>
 * 思路
 * 双端队列广搜
 * 待回看
 */
public class Q175_电路维修 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, INF = 0x3f3f3f3f;
    private static final int[] dx = new int[]{-1, -1, 1, 1}, dy = new int[]{-1, 1, 1, -1};
    /**
     * ix iy维护边的关系
     */
    private static final int[] ix = new int[]{-1, -1, 0, 0}, iy = new int[]{-1, 0, 0, -1};
    /**
     * 注意反斜杠默认用于转义，则在字符串中出现应为“\\”
     */
    private static final char[] cs = "\\/\\/".toCharArray();
    private static char[][] g = new char[N][N];
    private static int[][] d = new int[N][N];
    private static boolean[][] vis = new boolean[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            n = nextInt();
            m = nextInt();
            for (int i = 0; i < n; i++) {
                g[i] = next().toCharArray();
            }
            int ans = bfs();
            out.println(ans == INF ? "NO SOLUTION" : ans);
        }
        close();
    }

    private static int bfs() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], INF);
            Arrays.fill(vis[i], false);
        }
        d[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            if (vis[x][y]) {
                continue;
            }
            vis[x][y] = true;

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx > n || ny < 0 || ny > m) {
                    continue;
                }

                int cx = x + ix[i], cy = y + iy[i];
                int dis = d[x][y] + (g[cx][cy] != cs[i] ? 1 : 0);

                if (d[nx][ny] > dis) {
                    d[nx][ny] = dis;
                    if (g[cx][cy] != cs[i]) {
                        q.offer(new int[]{nx, ny});
                    } else {
                        q.offerFirst(new int[]{nx, ny});
                    }
                }
            }
        }

        return d[n][m];
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static String next() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
