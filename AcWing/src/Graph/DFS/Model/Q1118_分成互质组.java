package Graph.DFS.Model;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/08
 * <p>
 * 思路
 * 判断两数互质 -- 求两数最小公约数 -- gcd
 * 回溯试探所有可能的情况
 * 将ans置为最大值N，经剪枝，每次只会向更小的值变化
 */
public class Q1118_分成互质组 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10;
    private static int[] p = new int[N];
    private static int[][] groups = new int[N][N];
    private static boolean[] vis = new boolean[N];
    static int n, ans = N;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 0; i < n; i++) {
            p[i] = nextInt();
        }
        dfs(1, 0, 0, 0);
        out.println(ans);
        close();
    }

    private static void dfs(int g, int k, int gc, int tc) {
        // 剪枝
        if (g >= ans) {
            return;
        }
        // 当前已经得到一组合法结果，记录组的数目
        if (tc == n) {
            ans = g;
        }
        // 使用标志位维护是否需要新开一组
        boolean flag = true;
        for (int i = k; i < n; i++) {
            if (!vis[i] && check(groups[g], gc, i)) {
                flag = false;
                vis[i] = true;
                // groups二维数组维护第g组第gc+1个数在p数组中的位置
                groups[g][gc] = i;
                dfs(g, i + 1, gc + 1, tc + 1);
                // 还原
                vis[i] = false;
            }
        }
        if (flag) {
            dfs(g + 1, 0, 0, tc);
        }
    }

    /**
     * 判断新加入p[k]这个数后，其与该组内任意数是否均互质
     *
     * @param group 组
     * @param gc    组的大小（不是数组大小，是现有元素个数）
     * @param k     新加入数的idx
     * @return 是否互质，不满足则需新开一组
     */
    private static boolean check(int[] group, int gc, int k) {
        for (int i = 0; i < gc; i++) {
            if (gcd(p[group[i]], p[k]) > 1) {
                return false;
            }
        }
        return true;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
