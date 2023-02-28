package Array;

/**
 * @author Hyperspace
 * @date 2022/12/01
 * @file M1779_找到最近的有相同X或Y坐标的点.java
 * <p>
 * 思路
 * 模拟
 * 注：题干中指的下标是points数组的第一维的索引。。
 */
public class M1779_找到最近的有相同X或Y坐标的点 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;
        int dist = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            int cx = points[i][0], cy = points[i][1];
            if (x == cx || y == cy) {
                int d = getDist(x, y, cx, cy);
                if (d < dist) {
                    dist = d;
                    ans = i;
                }
            }
        }

        return ans;
    }

    int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
