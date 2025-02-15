package DP.LISModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/09
 * <p>
 * 思路 线性dp
 * 1. 状态表示
 * 集合：f[i]是从起始景点到当前编号为i景点所经过的最大景点数目
 * 属性：Max
 * <p>
 * 2. 状态计算
 * 只要能够识别出问题属于LIS问题，则此列问题的状态转移方程均相同
 * f[i] = max(f[i], f[j] + 1)
 */
public class Q1014_登山 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] h = new int[N], f = new int[N], g = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            h[i] = nextInt();
        }

        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (h[i] > h[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            g[i] = 1;
            for (int j = n; j > i; j--) {
                if (h[i] > h[j]) {
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, f[i] + g[i] - 1);
        }
        out.println(ans);

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
