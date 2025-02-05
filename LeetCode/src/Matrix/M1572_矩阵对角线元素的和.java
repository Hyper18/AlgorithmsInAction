package Matrix;

/**
 * @author Hyper
 * @date 2023/08/11
 * @file M1572_矩阵对角线元素的和.java
 * <p>
 * 思路
 * 模拟
 */
public class M1572_矩阵对角线元素的和 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || i + j == n - 1) {
                    sum += mat[i][j];
                }
            }
        }

        return sum;
    }
}
