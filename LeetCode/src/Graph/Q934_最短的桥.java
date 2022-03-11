package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/11
 * 思路
 * https://leetcode-cn.com/problems/shortest-bridge/solution/java-bfsyu-dfsshi-yong-by-ppppjqute-jvwv/
 * 主要点在于题目已经指明了只会有两座岛
 * 因此可以先使用dfs找到其中一座，再通过bfs向外扩展，找到最近的另一座岛屿并返回距离
 * <p>
 * 注：通过不同的点，bfs到另外一个岛的桥长都是一样的
 * bfs可以看做对dfs得到的岛进行一层一层扩展，扩展层数为最短距离
 */
public class Q934_最短的桥 {
    private int[][] grid;
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private Queue<int[]> queue;
    private boolean[][] visited;
    int m, n, ans;

    private void init() {
        ans = -1;
        queue = new ArrayDeque<>();
        visited = new boolean[m][n];
    }

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        init();
        boolean isMarked = false;
        for (int i = 0; i < m && !isMarked; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    isMarked = true;
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            ans += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int currRow = pos[0] + dir[0];
                    int currCol = pos[1] + dir[1];
                    if (isNotIn(currRow, currCol) || visited[currRow][currCol]) {
                        continue;
                    }
                    if (grid[currRow][currCol] == 1) {
                        return ans;
                    }
                    visited[currRow][currCol] = true;
                    queue.offer(new int[]{currRow, currCol});
                }
            }
        }

        return ans;
    }

    private void dfs(int row, int col) {
        if (isNotIn(row, col) || grid[row][col] != 1 || visited[row][col]) {
            return;
        }
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int currRow = row + dir[0];
            int currCol = col + dir[1];
            dfs(currRow, currCol);
        }
    }

    private boolean isNotIn(int row, int col) {
        return row < 0 || row >= m || col < 0 || col >= n;
    }
}
