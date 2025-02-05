package Graph.DFS.Model;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/06
 * <p>
 * 思路
 * bfs
 */
public class Q1113_红与黑_3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 20 + 3;
    private static final int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};
    private static char[][] g = new char[N][N];
    private static boolean[][] vis;
    static int n, m;

    public static void main(String[] args) throws IOException {
        while (true) {
            n = nextInt();
            m = nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            int sx = 0, sy = 0;
            for (int i = 0; i < m; i++) {
                String l = next();
                g[i] = l.toCharArray();
                if (l.indexOf('@') != -1) {
                    sx = i;
                    sy = l.indexOf('@');
                }
            }
            vis = new boolean[N][N];
            out.println(bfs(sx, sy));
        }
        close();
    }

    private static int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            ans++;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == '#') {
                    continue;
                }
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return ans;
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
