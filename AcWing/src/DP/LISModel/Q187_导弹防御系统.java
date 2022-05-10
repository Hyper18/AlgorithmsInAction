package DP.LISModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/10
 * 线性dp + 爆搜剪枝
 */
public class Q187_导弹防御系统 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 50 + 5;
    private static int[] h = new int[N];
    private static int[] up = new int[N], down = new int[N];
    static int n, ans;

    public static void main(String[] args) throws IOException {
        while (true) {
            n = nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                h[i] = nextInt();
            }
            ans = n;
            dfs(0, 0, 0);
            out.println(ans);
        }
        close();
    }

    private static void dfs(int u, int su, int sd) {
        if (su + sd > ans) {
            return;
        }
        if (u == n) {
            ans = su + sd;
            return;
        }

        // 情况1：将当前数放到上升子序列中
        int k = 0;
        while (k < su && up[k] >= h[u]) {
            k++;
        }
        if (k < su) {
            int t = up[k];
            up[k] = h[u];
            dfs(u + 1, su, sd);
            up[k] = t;
        } else {
            up[k] = h[u];
            dfs(u + 1, su + 1, sd);
        }

        // 情况2：将当前数放到下降子序列中
        k = 0;
        while (k < sd && down[k] <= h[u]) {
            k++;
        }
        if (k < sd) {
            int t = down[k];
            down[k] = h[u];
            dfs(u + 1, su, sd);
            down[k] = t;
        } else {
            down[k] = h[u];
            dfs(u + 1, su, sd + 1);
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
