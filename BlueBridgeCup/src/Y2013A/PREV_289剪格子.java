package Y2013A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/14
 * @time 93ms
 */
public class PREV_289剪格子 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] grid;
    private static boolean[][] vis;
    static int n, m, total, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        m = nextInt();
        n = nextInt();
        grid = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = nextInt();
                total += grid[i][j];
            }
        }

        dfs(0, 0, 0, 0);

        out.println(ans);

        close();
    }

    static void dfs(int x, int y, int steps, int sum) {
        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] || sum > total / 2) {
            return;
        }
        if (sum == total / 2) {
            ans = Math.min(ans, steps);
            return;
        }
        vis[x][y] = true;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1], steps + 1, sum + grid[x][y]);
        }
        vis[x][y] = false;
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}