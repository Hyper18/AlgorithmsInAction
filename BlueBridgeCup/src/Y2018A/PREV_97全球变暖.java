package Y2018A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/04
 * @time 187ms
 * 87/100
 * 先dfs一轮找出边界并记录所有岛屿的数量N1
 * 再二轮dfs对未淹没岛屿计数得到N2
 * N1-N2得到answer
 * 需要特别注意，如果第一轮找出岛屿边界后清除，可能留下多余的内部岛屿（被岛屿自身边界切割开来，从而多重复计数了未被淹没的岛屿数目）
 * <p>
 * 最后一个用例N=1000，dfs会溢出，待优化
 */
public class PREV_97全球变暖 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static char[][] grid;
    private static boolean[][] vis;
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        grid = new char[N + 1][N + 1];
        vis = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            String line = next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (grid[i][j] == '#' && !vis[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }

        vis = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '#' && !vis[i][j]) {
                    dfs(i, j);
                    ans--;
                }
            }
        }

        out.println(ans);

        close();
    }

    private static void dfs(int x, int y) {
        if (grid[x][y] == '.' || vis[x][y]) {
            return;
        }
        vis[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (grid[nx][ny] == '.') {
                grid[x][y] = 'M';
                continue;
            }
            dfs(nx, ny);
        }
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
