package Matrix;

/**
 * @author Hyper
 * @date 2022/02/15
 * <p>
 * 思路
 * 1. 模拟，不符合则输出原matrix -- O(rc)
 * 2. 官方解法，优化了过渡数组，直接利用取余重塑 -- O(rc)
 */
public class Q566_重塑矩阵 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[] tmp = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[idx++] = mat[i][j];
            }
        }

        int[][] res = new int[r][c];
        idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = tmp[idx++];
            }
        }

        return res;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        for (int idx = 0; idx < m * n; ++idx) {
            res[idx / c][idx % c] = mat[idx / n][idx % n];
        }
        return res;
    }
}
