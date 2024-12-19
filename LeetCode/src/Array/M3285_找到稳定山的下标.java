package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2024/12/19
 * @file M3285_找到稳定山的下标.java
 */
public class M3285_找到稳定山的下标 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        int n = height.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (height[i - 1] > threshold) {
                res.add(i);
            }
        }

        return res;
    }
}
