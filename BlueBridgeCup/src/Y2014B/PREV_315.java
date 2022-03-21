package Y2014B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/21
 * @time 93ms
 * dfs + 记忆化搜索 + dp
 * <p>
 * 注意ans不能设为静态变量，而需要动态进行更新
 */
public class PREV_315 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final long MOD = 1000000000 + 7;
    private static final int MAXN = 50;
    private static final int MAXK = 12;
    private static int[][] grid = new int[MAXN][MAXN];
    private static long[][][][] dp = new long[MAXN][MAXN][MAXK][MAXK];
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0, 0, -1);
        out.println(dp[0][0][0][0]);
        close();
    }

    public static long dfs(int x, int y, int num, int max) {
        if (dp[x][y][num][max + 1] != -1) {
            return dp[x][y][num][max + 1];
        }
        if (x == n - 1 && y == m - 1) {
            if (num == k || (num == k - 1 && max < grid[x][y])) {
                return dp[x][y][num][grid[x][y]] = 1L;
            } else {
                return dp[x][y][num][max + 1] = 0L;
            }
        }

        long ans = 0;
        if (x < n - 1) {
            if (max < grid[x][y]) {
                ans += dfs(x + 1, y, num + 1, grid[x][y]);
            }
            ans += dfs(x + 1, y, num, max);
        }
        if (y < m - 1) {
            if (max < grid[x][y]) {
                ans += dfs(x, y + 1, num + 1, grid[x][y]);
            }
            ans += dfs(x, y + 1, num, max);
        }

        return dp[x][y][num][max + 1] = ans % MOD;
    }

    public static void init() throws IOException {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = nextInt();
            }
        }
        for (int i = 0; i < MAXN; i++) {
            for (int j = 0; j < MAXN; j++) {
                for (int k = 0; k < MAXK; k++) {
                    for (int l = 0; l < MAXK; l++) {
                        dp[i][j][k][l] = -1L;
                    }
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