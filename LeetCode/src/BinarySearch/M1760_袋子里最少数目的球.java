package BinarySearch;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/02/12
 * @file M1760_袋子里最少数目的球.java
 * <p>
 * 思路
 * 二分，最小化最大值
 */
public class M1760_袋子里最少数目的球 {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (check(nums, maxOperations, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean check(int[] nums, int maxOperations, int m) {
        long cnt = 0;
        for (int num : nums) {
            cnt += (num - 1) / m;
        }

        return cnt <= maxOperations;
    }
}
