package Math;

import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2024/07/09
 * @file M3102_最小化曼哈顿距离.java
 * <p>
 * 思路
 * 根据提示2，把曼哈顿距离转换为切比雪夫距离
 * 构造[xi - yi, xi + yi]点集，使得
 * 距离转化为max(max(xi) - min(xi), max(yi) - min(yi))
 * 这需要保存其新的位置及对应次数，适用TreeMap
 * 依次枚举把每一个点移除后的情况
 */
public class M3102_最小化曼哈顿距离 {
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> tx = new TreeMap<>(), ty = new TreeMap<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            tx.put(x - y, tx.getOrDefault(x - y, 0) + 1);
            ty.put(x + y, ty.getOrDefault(x + y, 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] p : points) {
            int x = p[0], y = p[1];
            tx.put(x - y, tx.get(x - y) - 1);
            ty.put(x + y, ty.get(x + y) - 1);
            if (tx.get(x - y) == 0) {
                tx.remove(x - y);
            }
            if (ty.get(x + y) == 0) {
                ty.remove(x + y);
            }
            ans = Math.min(ans, Math.max(tx.lastKey() - tx.firstKey(), ty.lastKey() - ty.firstKey()));
            tx.put(x - y, tx.getOrDefault(x - y, 0) + 1);
            ty.put(x + y, ty.getOrDefault(x + y, 0) + 1);
        }

        return ans;
    }
}
