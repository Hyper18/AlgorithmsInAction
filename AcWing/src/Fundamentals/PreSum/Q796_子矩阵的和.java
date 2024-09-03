package Fundamentals.PreSum;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/03
 * <p>
 * 思路
 * 首先为每一个子矩阵赋初值
 * 对于每一层父矩阵，其值 = 自身 + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1]
 * <p>
 * 最后求二维区间和：
 * pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1]
 */
public class Q796_子矩阵的和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[][] pre = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt(), q = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }

        while (q-- > 0) {
            int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt();
            out.println(pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1]);
        }

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
