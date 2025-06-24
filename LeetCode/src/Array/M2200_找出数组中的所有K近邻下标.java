package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/06/24
 * @file M2200_找出数组中的所有K近邻下标.java
 */
public class M2200_找出数组中的所有K近邻下标 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    res.add(i);
                    break;
                }
            }
        }

        return res;
    }
}
