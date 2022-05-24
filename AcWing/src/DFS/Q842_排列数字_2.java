package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/07
 * <p>
 * 殊途同归的写法
 * 本质还是在做回溯
 * 省去了二次排序的时间消耗，但多使用了一组辅助数组的空间
 */
public class Q842_排列数字_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(System.out);
    private static final int N = 10;
    private static int[] path = new int[N];
    private static boolean[] st = new boolean[N];
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        dfs(0, 0);
        close();
    }

    private static void dfs(int k, int state) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    out.print(path[i]);
                    break;
                }
                out.print(path[i] + " ");
            }
            out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[k] = i;
                st[i] = true;
                dfs(k + 1, n);
                st[i] = false;
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
