package BackTracking;

/**
 * @author Hyperspace
 * @date 2024/12/04
 * @file M2056_棋盘上有效移动组合的数目.java
 * <p>
 * 思路@Esther
 * 回溯
 * 阻挡的情况：
 * 1) 前面的棋子位于当前位置
 * 2) 有棋子同时经过当前位置
 * 还需额外考虑本次不移动的情况
 */
public class M2056_棋盘上有效移动组合的数目 {
    private final int N = 8;
    private final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    private int[][][] g;

    public int countCombinations(String[] pieces, int[][] positions) {
        g = new int[positions.length][N][N];
        return backtrack(pieces, positions, 0);
    }

    public int backtrack(String[] pieces, int[][] positions, int i) {
        if (i == pieces.length) {
            return 1;
        }
        int x = positions[i][0] - 1, y = positions[i][1] - 1, ans = 0;
        for (int d = 0; d < N; d++) {
            if ((d < 4 && "bishop".equals(pieces[i]) || (d >= 4 && "rook".equals(pieces[i])))) {
                continue;
            }
            boolean blocked = false;
            for (int step = ans == 0 ? 1 : 2; !blocked; step++) {
                int nx = x + (step - 1) * dirs[d][0], ny = y + (step - 1) * dirs[d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    break;
                }
                boolean canStop = true;
                for (int j = 0; j < i; j++) {
                    int t = g[j][nx][ny];
                    canStop = canStop && t >= 0 && t < step;
                    blocked = blocked || (t < 0 && -t <= step) || t == step;
                }
                if (canStop) {
                    g[i][nx][ny] = -step;
                    ans += backtrack(pieces, positions, i + 1);
                }
                g[i][nx][ny] = step;
            }
            g[i] = new int[N][N];
        }

        return ans;
    }
}
