package DP.StMachineModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/12
 * <p>
 * 优化第一维
 */
public class Q1057_股票买卖IV_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10, M = 100 + 5, INF = 0x3f3f3f3f;
    private static int[] w = new int[N];
    private static int[][] f = new int[M][2];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1) {
                    f[j][1] = -w[i];
                } else {
                    f[j][0] = Math.max(f[j][0], f[j][1] + w[i]);
                    f[j][1] = Math.max(f[j][1], f[j - 1][0] - w[i]);
                }
            }
        }

        out.println(f[m][0]);

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
