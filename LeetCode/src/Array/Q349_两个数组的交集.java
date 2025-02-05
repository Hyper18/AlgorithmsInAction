package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/03/01
 * <p>
 * 思路
 * 1. 二分
 * 2. 哈希
 */
public class Q349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        Set<Integer> set = new HashSet<>();
        for (int num2 : nums2) {
            if (!set.contains(num2) && binarySearch(nums1, num2)) {
                set.add(num2);
            }
        }

        int[] res = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            res[idx++] = num;
        }

        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal > target) {
                high = mid - 1;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
