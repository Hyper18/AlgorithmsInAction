package Graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/30
 */
public class Q854_Floyd求最短路 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 200 + 10, INF = 0x3f3f3f3f;
    private static int[][] d = new int[N][N];
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = INF;
                }
            }
        }

        while (m-- > 0) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            d[a][b] = Math.min(d[a][b], c);
        }
        floyd();

        while (k-- > 0) {
            int a = nextInt(), b = nextInt();
            out.println(d[a][b] > INF / 2 ? "impossible" : d[a][b]);
        }
        close();
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
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
