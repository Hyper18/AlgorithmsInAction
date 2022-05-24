package DFS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/07
 * <p>
 * 思路
 * 全排列是基于分析出每行只能放一个皇后而逐行进行的
 * 更为原始的思考方式是分别搜索每行和每列 -- O(2^(n^2))
 */
public class Q843_n皇后问题_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10;
    private static char[][] g = new char[N][N];
    private static boolean[] row = new boolean[N], col = new boolean[N];
    private static boolean[] dg = new boolean[N * 2], udg = new boolean[N * 2];
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        dfs(0, 0, 0);
        close();
    }

    private static void dfs(int x, int y, int s) {
        if (s > n) {
            return;
        }
        if (y == n) {
            x++;
            y = 0;
        }
        if (x == n) {
            if (s == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(g[i][j]);
                    }
                    out.println();
                }
                out.println();
            }
            return;
        }
        // 该格不放皇后
        g[x][y] = '.';
        dfs(x, y + 1, s);
        // 该格放皇后
        if (!(row[x] || col[y] || dg[x + y] || udg[n - x + y])) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[n - x + y] = true;
            dfs(x, y + 1, s + 1);
            row[x] = col[y] = dg[x + y] = udg[n - x + y] = false;
            g[x][y] = '.';
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
