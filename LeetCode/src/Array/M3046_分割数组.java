package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/12/28
 * @file M3046_分割数组.java
 */
public class M3046_分割数组 {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.merge(num, 1, Integer::sum);
            if (mp.get(num) > 2) {
                return false;
            }
        }

        return true;
    }

    public boolean isPossibleToSplit2(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            if (++cnt[num] > 2) {
                return false;
            }
        }

        return true;
    }
}
