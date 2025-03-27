package BinarySearch;

/**
 * @author Hyper
 * @date 2023/12/19，2025/03/27
 * @file M1901_寻找峰值II.java
 * <p>
 * 思路
 * 1. 左闭右开二分
 * 先找到每行的最大值，再往递增方向走
 * 2. 闭区间二分
 */
public class M1901_寻找峰值II {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int i = low + ((high - low) >> 1), j = getMaxIdx(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                high = i;
            } else {
                low = i + 1;
            }
        }

        return new int[]{low, getMaxIdx(mat[low])};
    }

    public int[] findPeakGrid2(int[][] mat) {
        int n = mat.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int i = low + ((high - low) >> 1), j = getMaxIdx(mat[i]);
            if (i == n - 1 || mat[i][j] > mat[i + 1][j]) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return new int[]{low, getMaxIdx(mat[low])};
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
