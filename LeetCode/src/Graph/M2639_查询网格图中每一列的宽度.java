package Graph;

/**
 * @author Hyper
 * @date 2024/04/27
 * @file M2639_查询网格图中每一列的宽度.java
 * <p>
 * 思路
 * 模拟，图遍历列
 * 负数长度要加1，实际上是指的是涵盖了负号的长度
 */
public class M2639_查询网格图中每一列的宽度 {
    public static int[] findColumnWidth(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int s = Integer.toString(grid[j][i]).length();
                res[i] = Math.max(res[i], s);
            }
        }

        return res;
    }
}
