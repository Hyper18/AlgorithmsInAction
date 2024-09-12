package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/09/12
 * @file M2576_求出最多标记下标.java
 * <p>
 * 思路
 * 1. 二分
 * 一开始考虑排序后依次做二分
 * 后来发现匹配关系也具有单调性
 * 因此不是每次二分最小能满足2 * nums[i] <= nums[j]的j
 * 而是只用一次二分出能匹配的数对数目low*2
 * check依次检查最小、次小……数组成的数对是否满足2 * nums[i] <= nums[n - mid + i]
 * <p>
 * 2. 贪心
 */
public class M2576_求出最多标记下标 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        return binarySearch(nums);
    }

    private int binarySearch(int[] nums) {
        int low = 0, high = nums.length >> 1;
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (check(nums, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low << 1;
    }

    private boolean check(int[] nums, int mid) {
        for (int i = 0; i < mid; i++) {
            if (2 * nums[i] > nums[nums.length - mid + i]) {
                return false;
            }
        }

        return true;
    }

    public int maxNumOfMarkedIndices2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0, mid = n >> 1;
        for (int i = 0, j = mid; i < mid && j < n; j++) {
            if (2 * nums[i] <= nums[j]) {
                ans++;
                i++;
            }
        }

        return ans << 1;
    }
}
