package Graph.BFS.FloodFill;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/06/04
 */
public class Q1097_池塘计数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static char[][] g = new char[N][N];
    private static boolean[][] vis = new boolean[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        // 可以为直接二维数组的每行赋输入
        for (int i = 0; i < n; i++) {
            g[i] = next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]) {
                    continue;
                }
                if (g[i][j] == 'W') {
                    bfs(i, j);
                    ans++;
                }
            }
        }
        out.println(ans);
        close();
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    /*
                     * 判断重复的条件：
                     * 1. 八连通的中心点
                     * 2. 四个边界
                     * 3. 题目实际限制：陆地
                     * 4. 是否已被访问
                     */
                    if ((i == x && j == y) || i < 0 || i >= n || j < 0 || j >= m || g[i][j] == '.' || vis[i][j]) {
                        continue;
                    }
                    vis[i][j] = true;
                    q.offer(new int[]{i, j});
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
