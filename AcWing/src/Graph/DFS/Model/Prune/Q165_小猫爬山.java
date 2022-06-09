package Graph.DFS.Model.Prune;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/09
 * <p>
 * 思路
 * 回溯+剪枝
 */
public class Q165_小猫爬山 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 20;
    private static Integer[] w = new Integer[N];
    private static int[] sum = new int[N];
    static int n, m, ans = N;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = nextInt();
        }
        // 可先优化搜索顺序
        Arrays.sort(w, 0, n, Collections.reverseOrder());
        dfs(0, 0);
        out.println(ans);
        close();
    }

    private static void dfs(int u, int k) {
        // 可行性剪枝
        if (k >= ans) {
            return;
        }
        // 更新结果
        if (u == n) {
            ans = k;
            return;
        }
        for (int i = 0; i < k; i++) {
            if (sum[i] + w[u] <= m) {
                sum[i] += w[u];
                dfs(u + 1, k);
                sum[i] -= w[u];
            }
        }
        sum[k] = w[u];
        dfs(u + 1, k + 1);
        // 恢复
        sum[k] = 0;
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
