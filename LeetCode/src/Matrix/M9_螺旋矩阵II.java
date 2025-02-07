package Matrix;

/**
 * @author Hyper
 * @date 2025/02/07
 * @file M9_螺旋矩阵II.java
 * <p>
 * 思路
 * 模拟
 */
public class M9_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        for (int t = n - 1, l = 0; t > 0; t -= 2, l++) {
            int r = n - 1 - l;
            for (int j = 0; j < t && num <= n * n; j++) {
                res[l][l + j] = num++;
            }
            for (int i = 0; i < t && num <= n * n; i++) {
                res[l + i][r] = num++;
            }
            for (int j = t; j > 0 && num <= n * n; j--) {
                res[r][l + j] = num++;
            }
            for (int i = t; i > 0 && num <= n * n; i--) {
                res[l + i][l] = num++;
            }
        }
        if (n % 2 != 0) {
            res[n / 2][n / 2] = num;
        }

        return res;
    }
}
