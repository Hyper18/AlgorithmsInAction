package DP.Knapsack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/18
 * <p>
 * 多重背包问题的二进制优化
 * vector -- ArrayList
 */
class Good {
    int v;
    int w;

    public Good(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Q5_多重背包问题II {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 2000 + 10;
    private static int[] f = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();

        List<Good> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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
            for (int j = m; j >= good.v; j--) {
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
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
