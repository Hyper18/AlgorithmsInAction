package Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2025/03/25
 * @file M2711_对角线上不同值的数量差.java
 * <p>
 * 思路
 * 模拟 -- O(mn*min(m, n))
 */
public class M2711_对角线上不同值的数量差 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = check(grid, i, j);
            }
        }

        return res;
    }

    private int check(int[][] g, int x, int y) {
        int m = g.length, n = g[0].length;
        Set<Integer> st1 = new HashSet<>();
        for (int i = 1; i <= Math.min(x, y); i++) {
            st1.add(g[x - i][y - i]);
        }
        Set<Integer> st2 = new HashSet<>();
        for (int i = 1; i < Math.min(m - x, n - y); i++) {
            st2.add(g[x + i][y + i]);
        }
        int ans = st1.size() - st2.size();

        return ans > 0 ? ans : -ans;
    }
}
