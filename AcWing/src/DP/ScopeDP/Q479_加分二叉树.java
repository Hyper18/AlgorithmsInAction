package DP.ScopeDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/23
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：f[l][r]表示所有将[l, r]合并成一棵树的方式
 * 属性：Max
 * 2. 状态计算
 * 当前树的分数 = max(前一个状态下树的分数，当前树左子树 * 右子树 + 根节点 的分数)
 * f[l][r] = max(f[l][r], f[l][k - 1] * f[k + 1][r] + v[k])
 */
public class Q479_加分二叉树 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 30;
    private static int[] v = new int[N];
    private static int[][] f = new int[N][N], path = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
        }

        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    f[l][r] = v[l];
                    path[l][r] = l;
                } else {
                    for (int k = l; k <= r; k++) {
                        int leftSubTrees = k == l ? 1 : f[l][k - 1];
                        int rightSubTrees = k == r ? 1 : f[k + 1][r];
                        int score = leftSubTrees * rightSubTrees + v[k];
                        if (score > f[l][r]) {
                            f[l][r] = score;
                            path[l][r] = k;
                        }
                    }
                }
            }
        }

        out.println(f[1][n]);
        dfs(1, n);

        close();
    }

    private static void dfs(int l, int r) {
        if (l > r) {
            return;
        }
        int k = path[l][r];
        out.print(k + " ");
        dfs(l, k - 1);
        dfs(k + 1, r);
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
