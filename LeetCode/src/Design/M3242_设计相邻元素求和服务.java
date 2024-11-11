package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/11/09
 * @file M3242_设计相邻元素求和服务.java
 * <p>
 * 思路
 * 模拟
 */
public class M3242_设计相邻元素求和服务 {
    class NeighborSum {
        private final int[][][] dirs = {
                {{-1, 0}, {1, 0}, {0, -1}, {0, 1}},
                {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}
        };
        private int[][] g;
        private Map<Integer, int[]> mp;
        private int m, n;

        public NeighborSum(int[][] grid) {
            this.g = grid;
            this.mp = new HashMap<>();
            m = grid.length;
            n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mp.put(grid[i][j], new int[]{i, j});
                }
            }
        }

        public int adjacentSum(int value) {
            return getSum(value, 0);
        }

        public int diagonalSum(int value) {
            return getSum(value, 1);
        }

        public int getSum(int value, int idx) {
            int[] p = mp.get(value);
            int x = p[0], y = p[1];
            int ans = 0;
            for (int[] dir : dirs[idx]) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                ans += g[nx][ny];
            }

            return ans;
        }
    }

    /**
     * Your NeighborSum object will be instantiated and called as such:
     * NeighborSum obj = new NeighborSum(grid);
     * int param_1 = obj.adjacentSum(value);
     * int param_2 = obj.diagonalSum(value);
     */
}
