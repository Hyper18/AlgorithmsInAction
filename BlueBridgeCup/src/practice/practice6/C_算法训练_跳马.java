package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/19
 * @time 78ms
 * dfs, 回溯
 */
public class C_算法训练_跳马 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int SIZE = 8 + 1;
    private static final int MAX = 64;
    private static final int[][] dirs = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    private static boolean[][] vis = new boolean[SIZE][SIZE];
    private static int c, d, ans = MAX;

    public static void main(String[] args) throws IOException {
        int a = nextInt();
        int b = nextInt();
        c = nextInt();
        d = nextInt();

        dfs(a, b, 0);

        out.println(ans == MAX ? -1 : ans);

        close();
    }

    private static void dfs(int row, int col, int step) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || vis[row][col] || step >= ans) {
            return;
        }
        if (row == c && col == d) {
            ans = Math.min(ans, step);
            return;
        }
        vis[row][col] = true;
        for (int[] dir : dirs) {
            dfs(row + dir[0], col + dir[1], step + 1);
        }
        vis[row][col] = false;
    }

    private static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(token.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
