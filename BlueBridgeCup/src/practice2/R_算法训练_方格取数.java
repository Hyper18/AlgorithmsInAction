package practice2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * @time 62ms
 * <p>
 * 1. 一个人先走，走过的非0位置置0
 * 重点在于如何在第一次遍历后取掉路径上的数
 * 2. 两个人同时走，一次完成
 * <p>
 * 试错后采用法二解决
 * 注意这题的坑在于不能令数组大小为n，题干写明了给出的是“位置”，是从1开始的
 */
public class R_算法训练_方格取数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[][][][] dp;
    private static int[][] grid;

    private static void init(int n) {
        dp = new int[n][n][n][n];
        for (int i = 1; i < n; i++) {
            dp[i][0][0][0] = dp[i - 1][0][0][0] + grid[i][0];
            dp[0][0][i][0] = dp[0][0][i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j][0][0] = dp[0][j - 1][0][0] + grid[0][j];
            dp[0][0][0][j] = dp[0][0][0][j - 1] + grid[0][j];
        }
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int size = n + 1;
        grid = new int[size][size];
        while (true) {
            int x = nextInt();
            int y = nextInt();
            int w = nextInt();
            if (x == 0 && y == 0 && w == 0) {
                break;
            }
            grid[x][y] = w;
        }

        init(size);
        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    for (int y2 = 1; y2 <= n; y2++) {
                        int tmp1 = max(dp[x1 - 1][y1][x2 - 1][y2], dp[x1 - 1][y1][x2][y2 - 1]);
                        int tmp2 = max(dp[x1][y1 - 1][x2 - 1][y2], dp[x1][y1 - 1][x2][y2 - 1]);
                        dp[x1][y1][x2][y2] = max(tmp1, tmp2) + grid[x1][y1];
                        if (x1 != x2 && y1 != y2) {
                            dp[x1][y1][x2][y2] += grid[x2][y2];
                        }
                    }
                }
            }
        }

        out.println(dp[n][n][n][n]);

        close();
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}