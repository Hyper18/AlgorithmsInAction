package Graph.BFS.FloodFill;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/05
 * <p>
 * 思路
 * bfs
 * 容易考虑的问题：求两数，是分开bfs两次还是使用标志位
 * -- 标志位，时间复杂度更低，又只多使用了O(1)的空间
 * 注意：
 * 1. 这里判断是否访问过，应当在判断山脉边界之后
 * -- 因为根据题意，实际处理的边界可以已经被访问过
 * 2. 当周围不存在相邻区域，则同时将其视为山峰和山谷
 * -- 指明了当只有一块时，默认情况下应当为mount、valley均+1
 * 则默认情况下的标志位，应当能够使这两个值递增
 */
public class Q1106_山峰和山谷 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[][] g = new int[N][N];
    private static boolean[][] vis = new boolean[N][N];
    static int n;
    static boolean hasHigher, hasLower;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = nextInt();
            }
        }
        int mount = 0, valley = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    continue;
                }
                hasHigher = false;
                hasLower = false;
                bfs(i, j);
                if (!hasHigher) {
                    mount++;
                }
                if (!hasLower) {
                    valley++;
                }
            }
        }
        out.println(mount + " " + valley);
        close();
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if ((i == x && j == y) || i < 0 || i >= n || j < 0 || j >= n) {
                        continue;
                    }
                    if (g[i][j] != g[x][y]) { // 高度不同
                        if (g[i][j] > g[x][y]) {
                            hasHigher = true;
                        } else {
                            hasLower = true;
                        }
                    } else if (!vis[i][j]) { // 高度相同
                        vis[i][j] = true;
                        q.offer(new int[]{i, j});
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
