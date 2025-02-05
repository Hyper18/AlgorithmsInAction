package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2022/03/11
 * bfs
 * 注意bfs每层计数的位置
 */
public class Q1926_迷宫中离入口最近的出口 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int currRow = pos[0] + dir[0];
                    int currCol = pos[1] + dir[1];
                    if (isNotIn(currRow, currCol)) {
                        if (!(pos[0] == entrance[0] && pos[1] == entrance[1])) {
                            return ans;
                        }
                        continue;
                    } else if (maze[currRow][currCol] == '.') {
                        queue.offer(new int[]{currRow, currCol});
                        maze[currRow][currCol] = '+';
                    }
                }
            }
            ans++;
        }

        return -1;
    }

    private boolean isNotIn(int row, int col) {
        return row < 0 || row >= m || col < 0 || col >= n;
    }
}
