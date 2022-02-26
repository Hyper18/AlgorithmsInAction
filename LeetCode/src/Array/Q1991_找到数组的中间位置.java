package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/26
 * <p>
 * 思路
 * 前缀和
 * 同中心下标，注意数组中心位于最左端时、不存在中间位置时均返回-1
 */
public class Q1991_找到数组的中间位置 {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;

        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            } else {
                sum += nums[i];
            }
        }

        return -1;
    }
}
