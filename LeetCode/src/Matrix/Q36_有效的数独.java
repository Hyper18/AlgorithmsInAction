package Matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/02/15
 * <p>
 * 思路
 * 1. 暴力模拟
 * 2. Hash
 * 3. 数组
 */
public class Q36_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Set<Character> set;
        for (int i = 0; i < m; i++) {
            set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }

                    int row = (i - i % 3) / 3;
                    int col = (j - j % 3) / 3;
                    for (int k = row; k < row + 3; k++) {
                        for (int l = col; l < col + 3; l++) {
                            if ((board[k][l] == board[i][j]) && (k != i && l != j)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<Integer, Set<Integer>> area = new HashMap<>();

        for (int i = 0; i < m; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0';
                    int idx = i / 3 * 3 + j / 3;
                    if (row.get(i).contains(num) || col.get(j).contains(num) || area.get(idx).contains(num)) {
                        return false;
                    }
                    row.get(i).add(num);
                    col.get(j).add(num);
                    area.get(idx).add(num);
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] rows = new boolean[m][n];
        boolean[][] cols = new boolean[m][n];
        boolean[][] blocks = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0' - 1;
                    int idx = i / 3 * 3 + j / 3;
                    if (rows[i][num] || cols[j][num] || blocks[idx][num]) {
                        return false;
                    }
                    rows[i][num] = true;
                    cols[j][num] = true;
                    blocks[idx][num] = true;
                }
            }
        }

        return true;
    }
}
