package DP.LISModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/09
 * <p>
 * 思路 线性dp
 * 1. 状态表示
 * 集合：f[i]表示从最左端到当前第i个元素的LIS和的最大值
 * 属性：Max
 * 2. 状态计算
 * 相当于把计算最长长度替换为当前的最大值
 * f[i] = max(f[i], f[j] + a[i])
 */
public class Q1016_最大上升子序列和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] a = new int[N], f = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = a[i];
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    f[i] = Math.max(f[i], f[j] + a[i]);
                }
            }
            ans = Math.max(ans, f[i]);
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
