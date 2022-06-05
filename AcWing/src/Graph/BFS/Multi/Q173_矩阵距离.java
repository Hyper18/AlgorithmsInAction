package Graph.BFS.Multi;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/05
 * <p>
 * 思路
 * 多源BFS -- 应建立超级源点
 * 反向思考，找点到1的最短距离需要bfs多次，而从为1的点向外Flood Fill只需要bfs一次
 * 1. 先找出所有当前01矩阵中所有为1的位置，并通过二维数组d维护每个位置到最近1的曼哈顿距离
 * 2. 将这些点入队。这里采用枚举
 * 3. 从这些点中任取一点开始均可，顺次向外（四连通）的区域更新递增距离
 * <p>
 * 注意：
 * 1. 本题的输入比较坑，直接读整数是不行的（因为同一行的输入顺次连接）
 * -- 采用二维字符数组存储，每次输入一整行数据并转换为字符
 * 2. 思考多源bfs的转化方式！！
 * 3. 本题为什么不需要标志位维护各个位置的访问状态？
 * -- 实际上已经通过另一种方式鉴别，即条件中的 d[nx][ny] != -1
 * 由于最早我们先将所有位置为1的点的d均计为0，
 * 这样每次向外Flood Fill得到的d是递增的
 * 则没有访问过的d才是-1，其他均是访问过的位置
 */
public class Q173_矩阵距离 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static final int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};
    private static char[][] g = new char[N][N];
    private static int[][] d = new int[N][N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n; i++) {
            g[i] = next().toCharArray();
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(d[i][j] + " ");
            }
            out.println();
        }
        close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                d[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    d[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || d[nx][ny] != -1) {
                    continue;
                }
                q.offer(new int[]{nx, ny});
                d[nx][ny] = d[x][y] + 1;
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
