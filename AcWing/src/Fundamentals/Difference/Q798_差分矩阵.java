package Fundamentals.Difference;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/03
 */
public class Q798_差分矩阵 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[][] a = new int[N][N], b = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt(), q = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = nextInt();
                insert(i, j, i, j, a[i][j]);
            }
        }

        while (q-- > 0) {
            int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt(), c = nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
                out.print(b[i][j] + " ");
            }
            out.println();
        }

        close();
    }

    private static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
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
