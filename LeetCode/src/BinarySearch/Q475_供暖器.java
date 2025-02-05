package BinarySearch;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/03/01
 */
public class Q475_供暖器 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int house : houses) {
            int res = binarySearch(heaters, house);
            int res2 = res + 1;
            int left = res >= 0 ? house - heaters[res] : Integer.MAX_VALUE;
            int right = res2 < heaters.length ? heaters[res2] - house : Integer.MAX_VALUE;
            ans = Math.max(ans, Math.min(left, right));
        }

        return ans;
    }

    private int binarySearch(int[] nums, int target) {
        if (target < nums[0]) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = nums[mid];
            if (midVal > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        return low;
    }
}
