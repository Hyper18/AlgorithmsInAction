package DP.StCompressingModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/15
 * 思路
 * 1. 状态表示
 * 集合：考虑前i层，且前i层的状态为j的情况
 * 属性：方案数cnt
 * 2. 状态计算
 * f[i][j] = (f[i][j] + f[i - 1][k]) % MOD
 */
public class Q327_玉米田 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 12 + 3, M = 1 << 12, MOD = (int) 1e8;
    private static List<Integer> states = new ArrayList<>();
    private static ArrayList<Integer>[] head = new ArrayList[M];
    private static int[] w = new int[N];
    private static int[][] f = new int[N][M];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int t = nextInt();
                w[i] += (1 - t) << j;
            }
        }
        for (int i = 0; i < 1 << m; i++) {
            head[i] = new ArrayList<>();
            if (check(i)) {
                states.add(i);
            }
        }
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < states.size(); j++) {
                int a = states.get(i), b = states.get(j);
                if ((a & b) == 0) {
                    head[i].add(j);
                }
            }
        }

        f[0][0] = 1;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j < states.size(); j++) {
                for (int k : head[j]) {
                    if ((states.get(j) & w[i]) == 0) {
                        f[i][j] = (f[i][j] + f[i - 1][k]) % MOD;
                    }
                }
            }
        }

        out.println(f[n + 1][0]);

        close();
    }

    private static boolean check(int st) {
        for (int i = 0; i < m; i++) {
            if (((st >> i) & (st >> i + 1)) == 1) {
                return false;
            }
        }
        return true;
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
