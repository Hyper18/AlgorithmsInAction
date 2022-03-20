package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * @time 93ms
 * dfs + 回溯
 * 分别计算各行的可能情况，并作累加
 */
public class H_算法训练_车的放置 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int SIZE = 8;
    private static boolean[] vis = new boolean[SIZE + 1];
    static int n, ans = 1;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        dfs(1);
        out.println(ans);
        close();
    }

    private static void dfs(int step) {
        if (step > n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ans++;
                dfs(step + 1);
                vis[i] = false;
            }
        }
        dfs(step + 1);
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
