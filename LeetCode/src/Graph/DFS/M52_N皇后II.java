package Graph.DFS;

/**
 * @author Hyperspace
 * @date 2024/12/02
 * @file M52_N皇后II.java
 * <p>
 * 思路
 * 同Q51
 */
public class M52_N皇后II {
    private final int N = 10;
    private char[][] g = new char[N][N];
    private boolean[] col = new boolean[N], dg = new boolean[N << 1], udg = new boolean[N << 1];
    private int n, ans;

    public int totalNQueens(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        backtrack(0);

        return ans;
    }

    private void backtrack(int k) {
        if (k == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!(col[i] || dg[k + i] || udg[n - k + i])) {
                g[k][i] = 'Q';
                col[i] = dg[k + i] = udg[n - k + i] = true;
                backtrack(k + 1);
                col[i] = dg[k + i] = udg[n - k + i] = false;
                g[k][i] = '.';
            }
        }
    }
}
