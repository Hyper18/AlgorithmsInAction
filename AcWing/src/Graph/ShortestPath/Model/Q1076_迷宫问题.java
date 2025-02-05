package Graph.ShortestPath.Model;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/05
 * <p>
 * 在原有bfs问题的基础上，为了求出最短的两点之间的路线
 * 可借助宽搜求最短路径
 */
public class Q1076_迷宫问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static final int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};
    private static int[][] g = new int[N][N];
    private static int[][][] path = new int[N][N][2];
    private static boolean[][] vis = new boolean[N][N];
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = nextInt();
            }
        }
        bfs(n - 1, n - 1);
        int[] p = new int[]{0, 0};
        while (true) {
            int ex = p[0], ey = p[1];
            out.println(ex + " " + ey);
            if (ex == n - 1 && ey == n - 1) {
                break;
            }
            p = path[ex][ey];
        }
        close();
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == 1) {
                    continue;
                }
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                path[nx][ny] = p;
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
