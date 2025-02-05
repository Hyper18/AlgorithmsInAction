package DP.LISModel;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/09
 * <p>
 * 思路 线性dp
 * 1. 状态表示
 * 集合：f[i]表示从最左端城市到第i个城市所有可行申请的最大数目
 * 属性：Max
 * 2. 状态计算
 * f[i] = max(f[i], f[j] + 1)
 */
public class Q1012_友好城市 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 5000 + 10;
    private static PII[] a = new PII[N];
    private static int[] f = new int[N];

    public static class PII {
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = new PII(nextInt(), nextInt());
        }

        Arrays.sort(a, 1, n + 1, Comparator.comparingInt(a -> a.x));
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i].y > a[j].y) {
                    f[i] = Math.max(f[i], f[j] + 1);
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
