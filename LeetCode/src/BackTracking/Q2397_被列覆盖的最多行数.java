package BackTracking;

/**
 * @author Hyperspace
 * @date 2025/05/04
 * @file Q2397_被列覆盖的最多行数.java
 * <p>
 * 思路
 * 回溯
 */
public class Q2397_被列覆盖的最多行数 {
    private int[][] matrix;
    private int ans, numSelect;

    public int maximumRows(int[][] matrix, int numSelect) {
        this.matrix = matrix;
        this.numSelect = numSelect;
        backtrack(0, 0);

        return ans;
    }

    private void backtrack(int i, int cnt) {
        if (i == matrix[0].length) {
            if (cnt == numSelect) {
                int sum = matrix.length;
                for (int[] row : matrix) {
                    for (int v : row) {
                        if (v == 1) {
                            sum--;
                            break;
                        }
                    }
                }
                ans = Math.max(ans, sum);
            }
            return;
        }
        backtrack(i + 1, cnt);
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][i]--;
        }
        backtrack(i + 1, cnt + 1);
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][i]++;
        }
    }
}
