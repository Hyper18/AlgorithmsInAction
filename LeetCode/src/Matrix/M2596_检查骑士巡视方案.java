package Matrix;

/**
 * @author Hyperspace
 * @date 2023/09/13
 * @file M2596_检查骑士巡视方案.java
 * <p>
 * 思路
 * 开学补打，bfs
 * 变体，需要每次额外调整起点
 * 注意测试样例初始点卡0
 */
public class M2596_检查骑士巡视方案 {
    final int[][] dirs = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int sx = 0, sy = 0;
        for (int i = 1; i < n * n; i++) {
            boolean f = true;
            for (int[] d : dirs) {
                int nx = sx + d[0], ny = sy + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && i == grid[nx][ny]) {
                    f = false;
                    sx = nx;
                    sy = ny;
                    break;
                }
            }
            if (f) {
                return false;
            }
        }

        return true;
    }
}
