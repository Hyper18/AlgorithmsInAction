package Array;

/**
 * @author Hyperspace
 * @date 2024/08/13
 * @file M3151_特殊数组I.java
 * <p>
 * 思路
 * 模拟
 */
public class M3151_特殊数组I {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }

        return true;
    }
}
