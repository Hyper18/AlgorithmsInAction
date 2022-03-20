package practice.practice6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/20
 */
public class I_算法训练_24点 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[][] nums;
    private static int ans;
    private static boolean[] vis;
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        nums = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = nextInt();
            }
        }

        vis = new boolean[4];
        for (int i = 0; i < n; i++) {
            ans = 0;
            dfs(i, 0, 0);
            out.println(ans);
        }

        close();
    }

    private static void dfs(int time, int step, int res) {
        if (res > 24) {
            return;
        }
        if (step == 4) {
            ans = Math.max(ans, res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(time, step + 1, res + nums[time][i]);
                dfs(time, step + 1, res - nums[time][i]);
                dfs(time, step + 1, res * nums[time][i]);
                dfs(time, step + 1, res / nums[time][i]);
                vis[i] = false;
            }
        }
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
