package DP.Knapsack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/18
 * 混合背包问题
 * <p>
 * 思路 -- 方案一
 * 1. 拆分多重背包为01背包
 * 2. 分别处理01背包和完全背包
 */
public class Q7_混合背包问题 {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] f = new int[N];

    private static class Thing {
        int k, v, w;

        public Thing(int k, int v, int w) {
            this.k = k;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();

        List<Thing> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = nextInt(), w = nextInt(), s = nextInt();
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
            if (thing.k == -1) {
                for (int j = m; j >= thing.v; j--) {
                    f[j] = Math.max(f[j], f[j - thing.v] + thing.w);
                }
            } else {
                for (int j = thing.v; j <= m; j++) {
                    f[j] = Math.max(f[j], f[j - thing.v] + thing.w);
                }
            }
        }

        out.println(f[m]);

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