package TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2025/02/09
 * @file M80_删除有序数组中的重复项II.java
 * <p>
 * 思路
 * 1. 模拟 -- O(n^2)
 * 2. 双指针 -- O(n)
 */
public class M80_删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.merge(nums[i], 1, Integer::sum) > 2) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                n--;
                i--;
            }
        }

        return n;
    }

    public int removeDuplicates2_0(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int l = 2, t = Integer.MIN_VALUE;
        for (int r = 2; r < n; r++) {
            if (nums[r] != nums[r - 1] || nums[r] != nums[r - 2]) {
                if (t != Integer.MIN_VALUE) {
                    nums[l++] = t;
                }
                t = nums[r];
            }
        }
        if (t != Integer.MIN_VALUE) {
            nums[l++] = t;
        }

        return l;
    }

    public int removeDuplicates2_1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int l = 2;
        for (int r = 2; r < n; r++) {
            if (nums[r] != nums[l - 2]) {
                nums[l++] = nums[r];
            }
        }

        return l;
    }
}
