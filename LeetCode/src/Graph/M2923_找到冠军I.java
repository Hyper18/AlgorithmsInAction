package Graph;

/**
 * @author Hyper
 * @date 2024/04/12
 * @file M2923_找到冠军I.java
 * <p>
 * 思路
 * 模拟
 */
public class M2923_找到冠军I {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            int cnt = 0;
            for (int num : row) {
                cnt += num;
            }
            if (cnt == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
