package Graph.DFS.Model;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/08
 * <p>
 * 思路
 * dfs的搜索顺序
 * 本题需要找出所有能遍历棋盘的途径总数
 * 即从同一点出发，可以有多重遍历棋盘的路径
 * 通过深搜，每次进行试错
 * 当迭代深度恰等于棋盘格点数目时，则通过全局变量ans记录本次方式
 * 在dfs步出后，需要重新将当前这一层访问的格点的访问状态清除（回溯）
 * 从而能够使后续迭代可以使用该格点，再次进行dfs
 * <p>
 * 注：
 * 本题可以只使用一个二维数组维护棋盘的各个位置的访问情况即可
 */
public class Q1116_马走日 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10;
    private static final int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2}, dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
    private static boolean[][] g;
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            n = nextInt();
            m = nextInt();
            int x = nextInt(), y = nextInt();

            ans = 0;
            g = new boolean[N][N];
            dfs(x, y, 1);
            out.println(ans);
        }
        close();
    }

    private static void dfs(int sx, int sy, int step) {
        if (step == n * m) {
            ans++;
            return;
        }
        g[sx][sy] = true;
        for (int i = 0; i < 8; i++) {
            int x = sx + dx[i], y = sy + dy[i];
            if (x < 0 || x >= n || y < 0 || y >= m || g[x][y]) {
                continue;
            }
            dfs(x, y, step + 1);
        }
        g[sx][sy] = false;
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
