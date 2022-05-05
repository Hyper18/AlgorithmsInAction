package DP.Knapsack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 */
public class Q7_混合背包问题 {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 1000 + 10;
    private static int[] dp = new int[MAX];

    private static class Thing {
        int kind;
        int v;
        int w;

        public Thing(int kind, int v, int w) {
            this.kind = kind;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int V = nextInt();
        List<Thing> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int v = nextInt();
            int w = nextInt();
            int s = nextInt();
            if (s == -1 || s == 0) {
                list.add(new Thing(s, v, w));
            } else {
                for (int k = 1; k <= s; k <<= 1) {
                    s -= k;
                    list.add(new Thing(-1, k * v, k * w));
                }
                if (s > 0) {
                    list.add(new Thing(-1, s * v, s * w));
                }
            }
        }

        for (Thing thing : list) {
            if (thing.kind == -1) {
                for (int j = V; j >= thing.v; j--) {
                    dp[j] = Math.max(dp[j], dp[j - thing.v] + thing.w);
                }
            } else {
                for (int j = thing.v; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - thing.v] + thing.w);
                }
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