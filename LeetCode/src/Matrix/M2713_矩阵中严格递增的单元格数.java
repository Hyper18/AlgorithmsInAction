package Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2024/06/19
 * @file M2713_矩阵中严格递增的单元格数.java
 * <p>
 * 思路
 * DP
 * 开两个数组分别维护行和列的最大值
 * <p>
 * 时间复杂度 O(M2∗NLogN)
 * 空间复杂度 O(M∗N)
 */
public class M2713_矩阵中严格递增的单元格数 {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int ans = 0;
        int[] rowMax = new int[m], colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            int[] mx = new int[pos.size()];
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0], j = p[1];
                mx[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, mx[k]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0], j = p[1];
                rowMax[i] = Math.max(rowMax[i], mx[k]);
                colMax[j] = Math.max(colMax[j], mx[k]);
            }
        }

        return ans;
    }
}
