package ref;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/06
 * Floyd
 */
public class R18_多源最短路 {
    private static int MAXD = 1007;
    private static int INF = 0x3f3f3f3f;
    private static int[][] dp = new int[MAXD][MAXD];

    private static void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();

        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            dp[a][b] = Math.min(dp[a][b], w);
        }
        floyd(n);

        out.println(dp[1][n] == INF ? -1 : dp[1][n]);

        in.close();
        out.close();
    }
}
