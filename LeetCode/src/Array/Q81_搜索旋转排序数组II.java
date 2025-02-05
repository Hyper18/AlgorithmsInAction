package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/02/01
 * @file Q81_搜索旋转排序数组II.java
 */
public class Q81_搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

    public boolean search2(int[] nums, int target) {
        return Arrays.stream(nums).anyMatch(e -> e == target);
    }
}
