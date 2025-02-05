package TwoPointer;

/**
 * @author Hyper
 * @date 2025/02/04
 * @file M922_按奇偶排序数组II.java
 */
public class M922_按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, l = 0, r = 1; i < n; i++) {
            if ((nums[i] & 1) == 0) {
                res[l] = nums[i];
                l += 2;
            } else {
                res[r] = nums[i];
                r += 2;
            }
        }

        return res;
    }
}
