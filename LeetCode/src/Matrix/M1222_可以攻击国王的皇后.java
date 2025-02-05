package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/09/14
 * @file M1222_可以攻击国王的皇后.java
 * <p>
 * 思路
 * 模拟
 * 由于棋盘上只能有一个国王
 * 考虑从国王出发，向四个方向遍历第一个遇到的皇后
 */
public class M1222_可以攻击国王的皇后 {
    final int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    final int N = 8;
    boolean[][] f = new boolean[N][N];

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        for (int[] q : queens) {
            f[q[0]][q[1]] = true;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] d : dirs) {
            int x = king[0] + d[0], y = king[1] + d[1];
            while (x >= 0 && x < N && y >= 0 && y < N) {
                if (f[x][y]) {
                    List<Integer> li = new ArrayList<>();
                    li.add(x);
                    li.add(y);
                    res.add(li);
                    break;
                }
                x += d[0];
                y += d[1];
            }
        }

        return res;
    }
}
