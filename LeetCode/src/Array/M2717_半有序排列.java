package Array;

/**
 * @author Hyperspace
 * @date 2024/12/11
 * @file M2717_半有序排列.java
 */
public class M2717_半有序排列 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] == 1) {
                i = idx;
            }
            if (nums[idx] == n) {
                j = idx;
            }
        }

        return i + n - 1 - j - (j < i ? 1 : 0);
    }
}
