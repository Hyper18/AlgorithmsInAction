package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/03/09
 * <p>
 * dfs -- O(n^2)
 * 本题如果按照常规思路从内部点开始判断比较麻烦，
 * 考虑转换思路从边缘点开始往上走（溯源）
 * 找到既能流向大西洋、又能流向太平洋的点
 */
public class Q417_太平洋大西洋水流问题 {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[][] grid;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        grid = heights;
        m = heights.length;
        n = heights[0].length;
        if (m == 0 || n == 0) {
            return res;
        }
        boolean[][] reachP = new boolean[m][n];
        boolean[][] reachA = new boolean[m][n];

        int len = m > n ? m : n;
        for (int i = 0; i < len; i++) {
            if (i < m) {
                dfs(i, 0, reachP);
                dfs(i, n - 1, reachA);
            }
            if (i < n) {
                dfs(0, i, reachP);
                dfs(m - 1, i, reachA);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachA[i][j] && reachP[i][j]) {
                    List<Integer> output = new ArrayList<>();
                    output.add(i);
                    output.add(j);
                    res.add(output);
                }
            }
        }

        return res;
    }

    private void dfs(int x, int y, boolean[][] reachable) {
        reachable[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[x][y] <= grid[nx][ny] && !reachable[nx][ny]) {
                dfs(nx, ny, reachable);
            }
        }
    }
}
