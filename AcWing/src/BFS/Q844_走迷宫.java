package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/26
 * <p>
 * 思路
 * 从迷宫的左上方（1， 1）开始广搜
 * 广搜的特点已经决定了到达终点所需的移动次数是最少的
 */
public class Q844_走迷宫 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int N = 110;
    private static int[][] g = new int[N][N], d = new int[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                g[i][j] = nextInt();
            }
        }
        Queue<int[]> q = new LinkedList<>();
//        d[1][1] = 0;
        q.offer(new int[]{1, 1});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0], y = pos[1] + dir[1];
                if (x < 1 || x > n || y < 1 || y > m || g[x][y] == 1 || d[x][y] != 0) {
                    continue;
                }
                d[x][y] = d[pos[0]][pos[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
        out.println(d[n][m]);
        close();
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
