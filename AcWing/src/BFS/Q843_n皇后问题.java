package BFS;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/07
 * <p>
 * 思路
 * 全排列
 * 需要注意开判断对角线是否有皇后的数组大小为两倍
 * 因为为防止udg数组出现负数，人为添加了n，使得数组下标可以超过10
 */
public class Q843_n皇后问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10;
    private static char[][] g = new char[N][N];
    private static boolean[] col = new boolean[N];
    private static boolean[] dg = new boolean[N * 2], udg = new boolean[N * 2];
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        backtrack(0);
        close();
    }

    private static void backtrack(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(g[i][j]);
                }
                out.println();
            }
            out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!(col[i] || dg[k + i] || udg[n - k + i])) {
                g[k][i] = 'Q';
                col[i] = dg[k + i] = udg[n - k + i] = true;
                backtrack(k + 1);
                col[i] = dg[k + i] = udg[n - k + i] = false;
                g[k][i] = '.';
            }
        }
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
