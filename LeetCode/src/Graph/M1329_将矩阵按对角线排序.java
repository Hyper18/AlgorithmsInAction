package Graph;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/04/29
 * @file M1329_将矩阵按对角线排序.java
 * <p>
 * 思路
 * 模拟
 * 朴素做法，先取出再排序放回
 * <p>
 * 注意特判m == 1 || n == 1
 */
public class M1329_将矩阵按对角线排序 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        if (m == 1 || n == 1) {
            return mat;
        }
        int len = 2, idx;
        int[] a;
        for (int i = m - 2; i >= 0; i--) {
            a = new int[len];
            idx = 0;
            for (int j = 0; j < len; j++) {
                a[idx++] = mat[i + j][j];
            }
            Arrays.sort(a);
            idx = 0;
            for (int j = 0; j < len; j++) {
                mat[i + j][j] = a[idx++];
            }
            if (len < n) {
                len++;
            }
        }
        len = 2;
        for (int i = n - 2; i > 0; i--) {
            a = new int[len];
            idx = 0;
            for (int j = 0; j < len; j++) {
                a[idx++] = mat[j][i + j];
            }
            Arrays.sort(a);
            idx = 0;
            for (int j = 0; j < len; j++) {
                mat[j][i + j] = a[idx++];
            }
            if (len < m) {
                len++;
            }
        }

        return mat;
    }
}
