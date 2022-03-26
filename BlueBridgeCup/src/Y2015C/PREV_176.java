package Y2015C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/25
 * @time 156ms
 * n至少为5， 最大为999
 * 最开始思路是，从中间行开始往两边扩散
 * 最中间行：
 * floor(w / 2) + m个* + floor(w / 2)
 * 后来发现规律更简单
 * 可以直接初始化，再遍历两次标记*点
 */
public class PREV_176 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 999 + 10;
    private static char[][] grid = new char[MAX][MAX];

    public static void main(String[] args) throws IOException {
        int m = nextInt();
        int n = nextInt();

        int w = m + n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m + i; j++) {
                grid[i][j] = '*';
            }
            for (int j = w - 1 - i; j > w - 1 - m - i; j--) {
                grid[i][j] = '*';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
