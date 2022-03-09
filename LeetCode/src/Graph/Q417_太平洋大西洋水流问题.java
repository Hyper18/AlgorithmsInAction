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
 * 待回看
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

        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    List<Integer> output = new ArrayList<>();
                    output.add(i);
                    output.add(j);
                    res.add(output);
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, boolean[][] canReach) {
        canReach[row][col] = true;
        for (int[] dir : dirs) {
            int currRow = row + dir[0];
            int currCol = col + dir[1];
            if (isIn(currRow, currCol) && grid[row][col] <= grid[currRow][currCol] && !canReach[currRow][currCol]) {
                dfs(currRow, currCol, canReach);
            }
        }
    }

    private boolean isIn(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

}
