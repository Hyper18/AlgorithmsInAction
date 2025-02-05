package BinarySearch;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/11
 * 1. 调内置API
 * 2. 手写二分查找
 * 前提：没有重复元素
 * 本题为左闭右闭型，而部分题型可为最大元素不包含，是为
 * 3. 左闭右开写法
 */
public class Q704_二分查找 {
    public int search(int[] nums, int target) {
        int ans = Arrays.binarySearch(nums, target);
        return ans >= 0 ? ans : -1;
    }

    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // int mid = (low + high) >>> 1; binarySearch0()源码实现，无符号右移
            // int mid = low + ((high - low) >> 1); 符号右移，这样写则需要先判断target值在num[0]与nums[nums.length - 1]之间
            int mid = (low + high) / 2;
            int midVal = nums[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // 注意点1：小于
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = nums[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                // 注意点2：等于
                high = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
