package Graph.DFS.Model;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/06
 * <p>
 * 思路
 * 爆搜
 * 观察本题数据量只有20，适合直接dfs来做
 * <p>
 * 注意：
 * 多组查询时，需重置：
 * 1. 数组访问状态
 * 2. 递归中使用的用于统计的全局变量（如：cnt、max等）
 */
public class Q1113_红与黑 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 20 + 3;
    private static final int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};
    private static char[][] g = new char[N][N];
    private static boolean[][] vis;
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        while (true) {
            n = nextInt();
            m = nextInt();
            if (n == 0 && m == 0) {
                close();
                System.exit(0);
            }
            int sx = 0, sy = 0;
            for (int i = 0; i < m; i++) {
                String input = next();
                g[i] = input.toCharArray();
                if (input.indexOf('@') != -1) {
                    sx = i;
                    sy = input.indexOf('@');
                }
            }
            vis = new boolean[N][N];
            ans = 0;
            dfs(sx, sy);
            out.println(ans);
        }
    }

    private static void dfs(int x, int y) {
        ans++;
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == '#') {
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
