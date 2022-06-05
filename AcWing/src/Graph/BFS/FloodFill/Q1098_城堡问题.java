package Graph.BFS.FloodFill;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/05
 */
public class Q1098_城堡问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 50 + 5;
    private static final int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
    private static int[][] g = new int[N][N];
    private static boolean[][] vis = new boolean[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = nextInt();
            }
        }
        int cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]) {
                    continue;
                }
                ans = Math.max(ans, bfs(i, j));
                cnt++;
            }
        }
        out.println(cnt);
        out.println(ans);
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
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny] || (g[x][y] >> i & 1) != 0) {
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

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
