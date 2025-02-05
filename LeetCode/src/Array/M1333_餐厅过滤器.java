package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/09/27
 * @file M1333_餐厅过滤器.java
 * <p>
 * 思路
 * （自定义）排序
 * 分类讨论：
 * 1. 两者rating相同
 * ID大者在前
 * 2. 两者rating不同
 * rating大者在前
 */
public class M1333_餐厅过滤器 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        List<Integer> res = new ArrayList<>();
        for (int[] r : restaurants) {
            if (veganFriendly == 1 && r[2] == 0) {
                continue;
            }
            if (r[3] <= maxPrice && r[4] <= maxDistance) {
                res.add(r[0]);
            }
        }

        return res;
    }
}
