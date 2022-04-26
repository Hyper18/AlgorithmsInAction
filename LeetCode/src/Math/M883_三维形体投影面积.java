package Math;

/**
 * @author Hyperspace
 * @date 2022/04/26
 * <p>
 * 思路
 * 模拟
 * （1）俯视图：不为0的块个数
 * （2）正视图：取每一行的最大值
 * （3）侧视图：取每一列的最大值
 */
public class M883_三维形体投影面积 {
    public int projectionArea(int[][] grid) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < grid.length; i++) {
            int bMax = 0, cMax = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    a++;
                }
                if (grid[i][j] > bMax) {
                    bMax = grid[i][j];
                }
                if (grid[j][i] > cMax) {
                    cMax = grid[j][i];
                }
            }
            b += bMax;
            c += cMax;
        }

        return a + b + c;
    }
}
