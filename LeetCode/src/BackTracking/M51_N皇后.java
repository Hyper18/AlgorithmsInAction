package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/12/01
 * @file M51_N皇后.java
 * <p>
 * 思路
 * 全排列 -- O(n * n!)
 * 要注意开判断对角线是否有皇后的数组大小为两倍
 * 因为为防止udg数组出现负数，人为添加了n，使得数组下标可以超过10
 */
public class M51_N皇后 {
    private final int N = 10;
    private char[][] g = new char[N][N];
    private boolean[] col = new boolean[N], dg = new boolean[N << 1], udg = new boolean[N << 1];
    private List<List<String>> res = new ArrayList<>();
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        backtrack(0);

        return res;
    }

    private void backtrack(int k) {
        if (k == n) {
            List<String> row = new ArrayList<>();
            StringBuilder sb;
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(g[i][j]);
                }
                row.add(sb.toString());
            }
            res.add(row);
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
