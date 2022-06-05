package Graph.ShortestPath.Model;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/05
 * <p>
 * 思路
 * 借助bfs求最短路
 * 使用一个二维int数组维护最短长度
 * <p>
 * 注意：
 * 1. 输入的坑点，先输入的是列数
 * 2. 本题是八连通的变体，采用与四连通相似的写法
 * 3. 本题的重点给定为输入为‘K’字符的位置，需记录该位置的横、纵坐标
 * 4. 广搜保证了当搜索到终点时，一定是最短的。因此可以在到达终点后，直接退出bfs
 */
public class Q188_武士风度的牛 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 150 + 5;
    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2}, dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
    private static char[][] g = new char[N][N];
    private static boolean[][] vis = new boolean[N][N];
    private static int[][] d = new int[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        int sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            g[i] = next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'K') {
                    sx = i;
                    sy = j;
                }
            }
        }
        out.println(bfs(sx, sy));
        close();
    }

    private static int bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || g[nx][ny] == '*') {
                    continue;
                }
                if (g[nx][ny] == 'H') {
                    return d[x][y] + 1;
                }
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                d[nx][ny] = d[x][y] + 1;
            }
        }

        return -1;
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
