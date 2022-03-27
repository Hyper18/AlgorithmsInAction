package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hyperspace
 * @date 2022/03/27
 * 贪心法
 * 先将所有的points点集按照右边界从小到大顺序排序
 * 再从排序后的第一个点集的右端点开始
 * 如果该值小于下一个点集的左端点
 * 则更新（需要额外的一支箭）
 */
public class Q452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> a[1] - b[1]); // 注意：[[-2147483646,-2147483645],[2147483646,2147483647]] 会爆int
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int idx = points[0][1];
        int ans = 0;
        for (int[] x : points) {
            if (idx < x[0]) {
                idx = x[1];
                ans++;
            }
        }
        return ans;
    }
}
