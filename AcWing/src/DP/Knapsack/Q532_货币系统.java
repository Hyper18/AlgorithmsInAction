package DP.Knapsack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/11
 * <p>
 * 思路 求最大的线性无关组 -- 类似素数筛做法
 * 完全背包的方案数变体，
 * 若当前方案能满足，则放入
 * 不满足，则不含在最优解内
 * <p>
 * 待回看
 */
public class Q532_货币系统 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 25000 + 10;
    private static int[] v = new int[N];
    private static boolean[] f = new boolean[N];

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            for (int i = 0; i < n; i++) {
                v[i] = nextInt();
            }

            Arrays.sort(v, 0, n);
            // 每次应重新初始化
            Arrays.fill(f, false);
            f[0] = true;
            int ans = 0, m = v[n - 1];
            for (int i = 0; i < n; i++) {
                if (!f[v[i]]) {
                    ans++;
                }
                for (int j = v[i]; j <= m; j++) {
                    f[j] |= f[j - v[i]];
                }
            }
            out.println(ans);
        }
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
