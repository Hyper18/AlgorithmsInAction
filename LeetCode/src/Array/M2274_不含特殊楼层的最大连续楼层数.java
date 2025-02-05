package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/01/06
 * @file M2274_不含特殊楼层的最大连续楼层数.java
 */
public class M2274_不含特殊楼层的最大连续楼层数 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = 0, l = bottom;
        for (int r : special) {
            ans = Math.max(ans, r - l);
            l = r + 1;
        }

        return Math.max(ans, top - l + 1);
    }
}
