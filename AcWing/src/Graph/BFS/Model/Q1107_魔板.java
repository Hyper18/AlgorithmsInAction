package Graph.BFS.Model;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/05
 * <p>
 * 思路
 * 1. 全排列：回溯、剪枝
 * 2. bfs
 */
public class Q1107_魔板 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 8;
    private static int[] a = new int[]{1, 2, 3, 4, 8, 7, 6, 5};

    public static void main(String[] args) throws IOException {
        int[] ed = new int[N];
        for (int i = 0; i < N; i++) {
            ed[i] = nextInt();
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
