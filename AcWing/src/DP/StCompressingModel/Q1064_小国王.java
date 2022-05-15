package DP.StCompressingModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/14
 * <p>
 * 思路 状压dp
 * 使用二进制 & 1压缩状态
 * (state >> i) == 1 表示当前状态下，在本层的第k个位置上放了国王
 * 1. 状态表示
 * 集合：f[i][j][a]表示对前i层棋盘，放置了j个国王的前提下，令第i层的状态为k的方案数
 * 属性：方案数cnt
 * 2. 状态计算
 * f[i][j][a] += f[i - 1][j - c][b]
 * <p>
 * 注：在Java中使用ArrayList数组替换Vector需要注意初始化问题（判null，line 45）
 */
public class Q1064_小国王 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 12, M = 1 << 10, K = 110;
    private static ArrayList<Integer>[] head = new ArrayList[M];
    private static List<Integer> states = new ArrayList<>();
    private static int[] cnt = new int[M];
    private static long[][][] f = new long[N][K][M];
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < 1 << n; i++) {
            if (check(i)) {
                states.add(i);
                cnt[i] = count(i);
            }
        }
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < states.size(); j++) {
                int a = states.get(i), b = states.get(j);
                if ((a & b) == 0 && (check(a | b))) {
                    if (head[i] == null) {
                        head[i] = new ArrayList<>();
                    }
                    head[i].add(j);
                }
            }
        }

        // 初始化：当第i层不摆放任何国王时，该状态可以作为一种方案
        f[0][0][0] = 1;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j <= m; j++) {
                for (int a = 0; a < states.size(); a++) {
                    for (int b : head[a]) {
                        int c = cnt[states.get(a)];
                        if (j >= c) {
                            f[i][j][a] += f[i - 1][j - c][b];
                        }
                    }
                }
            }
        }

        // 获取最终状态结果：只要第n + 1层不摆东西，则上一层只要合法，那一定可以转移到这一层的这个状态
        out.println(f[n + 1][m][0]);

        close();
    }

    /**
     * 统计当前状态中位数为1的个数
     *
     * @param st 当前状态
     * @return 统计结果
     */
    private static int count(int st) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += st >> i & 1;
        }
        return ans;
    }

    /**
     * 检查：相邻两位不能同时为1
     * 若同时为1，则意味着此时一个国王的相邻位置中存在另一个国王
     *
     * @param st 当前状态
     * @return 检查结果
     */
    private static boolean check(int st) {
        for (int i = 0; i < n; i++) {
            if ((st >> i & 1) == 1 && (st >> i + 1 & 1) == 1) {
                return false;
            }
        }
        return true;
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
