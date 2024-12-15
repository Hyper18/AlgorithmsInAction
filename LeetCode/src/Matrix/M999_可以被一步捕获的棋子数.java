package Matrix;

/**
 * @author Hyperspace
 * @date 2024/12/06
 * @file M999_可以被一步捕获的棋子数.java
 * <p>
 * 思路
 * 模拟
 */
public class M999_可以被一步捕获的棋子数 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public int numRookCaptures(char[][] board) {
        m = board.length;
        n = board[0].length;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int[] dir : dirs) {
            for (int step = 1; ; step++) {
                int nx = x + dir[0] * step, ny = y + dir[1] * step;
                if (!isIn(nx, ny) || board[nx][ny] == 'B') {
                    break;
                }
                if (board[nx][ny] == 'p') {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    private boolean isIn(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
