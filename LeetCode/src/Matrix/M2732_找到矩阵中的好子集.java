package Matrix;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2024/06/25
 * @file M2732_找到矩阵中的好子集.java
 * <p>
 * 思路
 * 二进制矩阵上的位运算
 * 预处理位掩码
 * k行中每列和至多为k/2
 * 总的1的个数至多为kn/2
 * 平均n/2
 * 最小值不超过平均值，所以1的个数最少的那一行，至多有n/2个1
 * <p>
 * 待回看
 */
public class M2732_找到矩阵中的好子集 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                t |= grid[i][j] << j;
            }
            if (t == 0) {
                return Collections.singletonList(i);
            }
            mp.put(t, i);
        }
        for (Map.Entry<Integer, Integer> e1 : mp.entrySet()) {
            for (Map.Entry<Integer, Integer> e2 : mp.entrySet()) {
                if ((e1.getKey() & e2.getKey()) == 0) {
                    int i = e1.getValue(), j = e2.getValue();
                    return i < j ? Arrays.asList(i, j) : Arrays.asList(j, i);
                }
            }
        }

        return new ArrayList<>();
    }
}
