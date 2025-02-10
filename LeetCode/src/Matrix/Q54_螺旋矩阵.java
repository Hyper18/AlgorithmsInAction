package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/02/10
 * @file Q54_螺旋矩阵.java
 * <p>
 * 思路
 * 模拟
 */
public class Q54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        if (m == 1 || n == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res.add(matrix[i][j]);
                }
            }
            return res;
        }
        int cnt = m * n;
        for (int s = m - 1, t = n - 1, l = 0; s > 0 || t > 0; s -= 2, t -= 2, l++) {
            int r = n - 1 - l, u = m - 1 - l;
            for (int j = 0; j < t && cnt > 0; j++, cnt--) {
                res.add(matrix[l][l + j]);
            }
            for (int i = 0; i < s && cnt > 0; i++, cnt--) {
                res.add(matrix[l + i][r]);
            }
            for (int j = t; j > 0 && cnt > 0; j--, cnt--) {
                res.add(matrix[u][l + j]);
            }
            for (int i = s; i > 0 && cnt > 0; i--, cnt--) {
                res.add(matrix[l + i][l]);
            }
        }
        if (m == n && n % 2 != 0) {
            res.add(matrix[m / 2][n / 2]);
        }

        return res;
    }
}
