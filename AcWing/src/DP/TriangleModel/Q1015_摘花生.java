package DP.TriangleModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/08
 * 思路
 * dfs
 */
public class Q1015_摘花生 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}};
    private static int[][] g;
    static int r, c, ans;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        while (n-- > 0) {
            ans = 0;
            r = nextInt();
            c = nextInt();
            g = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    g[i][j] = nextInt();
                }
            }
            dfs(0, 0, 0);
            out.println(ans);
        }
        close();
    }

    private static void dfs(int x, int y, int cnt) {
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return;
        }
        if (x == r - 1 && y == c - 1) {
            ans = Math.max(ans, cnt + g[r - 1][c - 1]);
            return;
        }
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(nx, ny, cnt + g[x][y]);
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
