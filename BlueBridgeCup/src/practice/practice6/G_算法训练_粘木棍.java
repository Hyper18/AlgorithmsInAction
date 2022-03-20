package practice.practice6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * @time 359ms
 * dfs
 */
public class G_算法训练_粘木棍 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static boolean[] vis;
    private static int[] sticks;
    private static int[] nums;
    static int n, m, ans = 0;


    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        out.println(ans);
        close();
    }

    private static void dfs(int step) {
        if (step == n) {
            int max = Arrays.stream(sticks).max().getAsInt();
            int min = Arrays.stream(sticks).min().getAsInt();
            ans = Math.min(ans, max - min);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!vis[step]) {
                sticks[i] += nums[step];
                vis[step] = true;
                dfs(step + 1);
                vis[step] = false;
                sticks[i] -= nums[step];
            }
        }
    }

    private static void init() throws IOException {
        n = nextInt();
        m = nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
            ans += nums[i];
        }
        vis = new boolean[n];
        sticks = new int[m];
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
