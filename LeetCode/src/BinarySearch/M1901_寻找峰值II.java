package BinarySearch;

/**
 * @author Hyperspace
 * @date 2023/12/19
 * @file M1901_寻找峰值II.java
 * <p>
 * 思路
 * 二分，先找到每行的最大值，再往递增方向走
 */
public class M1901_寻找峰值II {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int i = l + ((r - l) >> 1);
            int j = getMaxIdx(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                r = i;
            } else {
                l = i + 1;
            }
        }

        return new int[]{l, getMaxIdx(mat[l])};
    }

    private int getMaxIdx(int[] row) {
        int n = row.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (row[i] > row[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
