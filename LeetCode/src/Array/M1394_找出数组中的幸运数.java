package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/07/05
 * @file M1394_找出数组中的幸运数.java
 */
public class M1394_找出数组中的幸运数 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : arr) {
            mp.merge(x, 1, Integer::sum);
        }
        int ans = -1;
        for (int x : arr) {
            if (mp.get(x) == x) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}
