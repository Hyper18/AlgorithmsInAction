package Matrix;

/**
 * @author Hyper
 * @date 2024/07/05
 * @file M3033_修改矩阵.java
 */
public class M3033_修改矩阵 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int mx = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] > mx) {
                    mx = matrix[j][i];
                }
            }
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = mx;
                }
            }
        }

        return matrix;
    }
}
