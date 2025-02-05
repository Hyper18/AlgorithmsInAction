package Graph.DFS.Model;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/06
 * <p>
 * 思路
 * 每次在递归函数出口累加并记录访问数目
 */
public class Q1113_红与黑_2 {
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
            out.println(dfs(sx, sy));
        }
        close();
    }

    private static int dfs(int x, int y) {
        int ans = 1;
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == '#') {
                continue;
            }
            ans += dfs(nx, ny);
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
