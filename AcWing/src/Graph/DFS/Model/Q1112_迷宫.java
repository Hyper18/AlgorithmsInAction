package Graph.DFS.Model;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/06
 * <p>
 * 思路
 * dfs判断连通性（四连通）
 */
public class Q1112_迷宫 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 5;
    private static final int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};
    private static char[][] g = new char[N][N];
    private static boolean[][] vis = new boolean[N][N];
    static int n, ex, ey;

    public static void main(String[] args) throws IOException {
        int k = nextInt();
        while (k-- > 0) {
            n = nextInt();
            for (int i = 0; i < n; i++) {
                g[i] = next().toCharArray();
                // 记得多组查询应重置查询状态
                Arrays.fill(vis[i], false);
            }
            int xa = nextInt(), ya = nextInt();
            ex = nextInt();
            ey = nextInt();
            out.println(dfs(xa, ya) ? "YES" : "NO");
        }
        close();
    }

    private static boolean dfs(int x, int y) {
        if (g[x][y] == '#') {
            return false;
        }
        if (x == ex && y == ey) {
            return true;
        }
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || vis[nx][ny]) {
                continue;
            }
            if (dfs(nx, ny)) {
                return true;
            }
        }

        return false;
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
