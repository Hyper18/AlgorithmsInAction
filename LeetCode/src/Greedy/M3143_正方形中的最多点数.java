package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/08/03
 * @file M3143_正方形中的最多点数.java
 * <p>
 * 思路
 * 排序+贪心
 * 根据离原点的距离升序排序
 * 对每一个点，只需要维护其(x, y)中的较大值与点对应的标识tag
 * 之后由内而外遍历即可
 * <p>
 * 注意题干要求：如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内
 * 进而如果直接累加ans，会导致多计入和相同tag同在边界上的点
 * 因此需要额外维护一个临时变量t，用于收集在同个边界上的不重复tag的点
 * 并在确保没有重复点后，再加入ans
 */
public class M3143_正方形中的最多点数 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        List<int[]> dis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1], tag = s.charAt(i) - 'a';
            dis.add(new int[]{Math.max(x < 0 ? -x : x, y < 0 ? -y : y), tag});
        }
        dis.sort(Comparator.comparingInt(a -> a[0]));
        int ans = 0, t = 0;
        boolean[] vis = new boolean[26];
        int last = 0;
        for (int[] p : dis) {
            if (last < p[0]) {
                ans += t;
                t = 0;
                last = p[0];
            }
            if (vis[p[1]]) {
                return ans;
            }
            vis[p[1]] = true;
            t++;
        }

        return ans + t;
    }
}
