package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/07/06
 * @file M1865_找出和为指定值的下标对.java
 * <p>
 * 思路
 * 哈希
 */
public class M1865_找出和为指定值的下标对 {
    class FindSumPairs {
        private int[] nums1, nums2;
        private Map<Integer, Integer> cnt;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.cnt = new HashMap<>();
            for (int num : nums2) {
                cnt.merge(num, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            cnt.merge(nums2[index], -1, Integer::sum);
            nums2[index] += val;
            cnt.merge(nums2[index], 1, Integer::sum);
        }

        public int count(int tot) {
            int ans = 0;
            for (int num : nums1) {
                ans += cnt.getOrDefault(tot - num, 0);
            }

            return ans;
        }
    }
}
