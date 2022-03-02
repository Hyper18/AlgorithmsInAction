package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/02
 * <p>
 * 注意数据量过大会爆int
 */
public class ALGO_226 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        long[][] b = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = in.nextInt();
            }
        }
        long[][] c = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = in.nextInt();
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long max = Long.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                long profit = Math.min(a[i][j], b[i][j]) * c[i][j];
                if (profit > max) {
                    max = profit;
                }
            }
            sum += max;
        }

        out.println(sum);

        in.close();
        out.close();
    }
}
