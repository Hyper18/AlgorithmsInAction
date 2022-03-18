package Knapsack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 * <p>
 * 多重背包问题的单调队列优化
 * to-do，有空补 这里用二的方法java是可以过的hh
 */
public class Q6_多重背包问题III {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 20000 + 10;
    private static int[] dp = new int[MAX];

    static class Good {
        int v;
        int w;

        public Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();

        List<Good> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int v = nextInt();
            int w = nextInt();
            int s = nextInt();
            for (int k = 1; k <= s; k <<= 1) {
                s -= k;
                list.add(new Good(v * k, w * k));
            }
            if (s > 0) {
                list.add(new Good(v * s, w * s));
            }
        }

        for (Good good : list) {
            for (int j = V; j >= good.v; j--) {
                dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
            }
        }

        out.println(dp[V]);

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
