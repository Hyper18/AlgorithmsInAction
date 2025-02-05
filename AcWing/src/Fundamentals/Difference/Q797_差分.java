package Fundamentals.Difference;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/03
 * <p>
 * 思路
 */
public class Q797_差分 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N];
    private static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            // 初始化原数组
            a[i] = nextInt();
            // 初始化差分数组，差分数组的定义：b[i] = a[i] - a[i - 1]
            // 下面两种写法的效果是等同的：
            // 1. 默认a[i]为未赋值的状态即开始进行差分
            // insert(i, i, a[i]);
            // 2. 从定义入手的写法
            b[i] = a[i] - a[i - 1];
        }

        while (m-- > 0) {
            int l = nextInt(), r = nextInt(), c = nextInt();
            // 进行差分操作
            insert(l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            // 最终序列；取差分数组的前缀和
            b[i] += b[i - 1];
            out.print(b[i] + " ");
        }

        close();
    }

    private static void insert(int l, int r, int c) {
        // 为从l开始的区间加上差分值c
        b[l] += c;
        // 为从r往后的区间恢复差分
        b[r + 1] -= c;
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
