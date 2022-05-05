package DP.ScopeDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 * <p>
 * 思路
 * 1. 状态表示
 * 属性：所有将第i堆石子到第j堆石子合并成一堆石子的合并方式
 * 分成k类，找分界线；每一类的最小代价求min
 * 2. 状态计算
 * f[l][r] = min(f[l][r], f[l][k] + f[k + 1][r] + a[r] - a[l - 1])
 * ans：将第一堆到第n堆合并起来的最小代价 - f[1][n]
 * <p>
 * 左边这堆的最小代价 + 右边 + 最后一步的最小代价
 * 区间内的元素个数 k = j - i + 1
 * 采用前缀和求总和，再分别求区间和
 * <p>
 * 待回看
 */
public class Q282_石子合并 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 300 + 10;
    private static final int INF = 0x3f3f3f3f;
    private static int[] a = new int[N];
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + nextInt();
        }

        // 这里取区间长度从2开始；当区间长度为1时，花费代价恒为0
        for (int len = 2; len <= n; len++) {
            // 依次枚举区间
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i, r = i + len - 1;
                // 需要预先指定一个较大的数值，否则得到的结果总是为0
                f[l][r] = INF;
                // 找该区间长度下，采用不同分界线所得到的区间和中的最小代价
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + a[r] - a[l - 1]);
                }
            }
        }

        out.println(f[1][n]);

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
