package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/19
 * 50/100
 * 二维01背包问题
 * 这题如果状压了就不好解决血量问题了
 */
public class B_算法训练_黑心药商 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAXN = 200 + 5;
    private static final int MAXP = 1000 + 10;
    private static int[] hps = new int[MAXN];
    private static int[] prices = new int[MAXN];
    private static int[][] dp = new int[MAXN][MAXP];
    private static boolean[] f = new boolean[MAXN];

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int M = nextInt();
        int P = nextInt();
        for (int i = 0; i < N; i++) {
            hps[i] = nextInt();
        }
        for (int i = 0; i < N; i++) {
            prices[i] = nextInt();
        }
        int idx = 1;
        for (int i = 0; i < M; i++) {
            int c1 = nextInt();
            int c2 = nextInt();
            int minus = nextInt();
            f[c1 - 1] = true;
            f[c2 - 1] = true;
            for (int j = 1; j <= P; j++) {
                if (j >= prices[c1 - 1] && dp[idx - 1][j - prices[c1 - 1]] + hps[c1 - 1] > dp[idx - 1][j]) {
                    dp[idx][j] = dp[idx - 1][j - prices[c1 - 1]] + hps[c1 - 1];
                    if (j + prices[c2 - 1] <= P) {
                        dp[idx + 1][j + prices[c2 - 1]] = dp[idx][j] + hps[c2 - 1] - minus;
                    }
                } else {
                    dp[idx][j] = dp[idx - 1][j];
                }
                if (dp[idx + 1][j] == 0) {
                    if (j > prices[c2 - 1]) {
                        dp[idx + 1][j] = Math.max(dp[idx][j], dp[idx][j - prices[c2 - 1]] + hps[c2 - 1]);
                    } else {
                        dp[idx + 1][j] = dp[idx][j];
                    }
                }
            }
            idx += 2;
        }

        for (int i = 0; i < N; i++) {
            if (f[i]) {
                continue;
            }
            for (int j = 1; j <= P; j++) {
                if (j >= prices[i]) {
                    dp[idx][j] = Math.max(dp[idx - 1][j], dp[idx - 1][j - prices[i]] + hps[i]);
                } else {
                    dp[idx][j] = dp[idx - 1][j];
                }
            }
            idx++;
        }

        out.println(dp[N][P]);

        close();
    }

    private static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(token.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
