package Graph.ShortestPath.Single;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/06/04
 * <p>
 * 思路
 * 朴素Dijkstra -- O(V^2)
 */
public class Q903_昂贵的聘礼_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10, INF = 0x3f3f3f3f;
    private static int[][] w = new int[N][N];
    /**
     * level数组用于存放主人的地位等级
     */
    private static int[] d = new int[N], level = new int[N];
    private static boolean[] vis = new boolean[N];
    static int m, n;

    public static void main(String[] args) throws IOException {
        m = nextInt();
        n = nextInt();
        for (int i = 0; i <= n; i++) {
            Arrays.fill(w[i], INF);
        }
        for (int i = 1; i <= n; i++) {
            int price = nextInt();
            level[i] = nextInt();
            int cnt = nextInt();
            // 初始化
            w[0][i] = Math.min(w[0][i], price);
            // 枚举第i位主人的每一项可替代品
            while (cnt-- > 0) {
                int j = nextInt(), value = nextInt();
                w[j][i] = Math.min(w[j][i], value);
            }
        }
        int ans = INF;
        // 枚举每个等级区间（必须包含酋长（总为1））
        for (int i = level[1] - m; i <= level[1]; i++) {
            ans = Math.min(ans, dijkstra(i, i + m));
        }
        out.println(ans);
        close();
    }

    private static int dijkstra(int l, int r) {
        Arrays.fill(d, INF);
        Arrays.fill(vis, false);
        d[0] = 0;
        for (int i = 1; i <= n + 1; i++) {
            int t = -1;
            for (int j = 0; j <= n; j++) {
                if (vis[j]) {
                    continue;
                }
                if (t == -1 || d[t] > d[j]) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 1; j <= n; j++) {
                // 考虑区间
                if (l <= level[j] && level[j] <= r) {
                    d[j] = Math.min(d[j], d[t] + w[t][j]);
                }
            }
        }

        return d[1];
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
