package Matrix;

/**
 * @author Hyper
 * @date 2025/08/25
 * @file M498_对角线遍历.java
 * <p>
 * 思路
 * 模拟
 */
public class M498_对角线遍历 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if ((i & 1) == 0) {
                int x = i < m ? i : m - 1, y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[idx++] = mat[x--][y++];
                }
            } else {
                int x = i < n ? 0 : i - n + 1, y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[idx++] = mat[x++][y--];
                }
            }
        }

        return res;
    }
}
