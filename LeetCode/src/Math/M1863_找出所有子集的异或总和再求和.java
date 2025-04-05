package Math;

/**
 * @author Hyperspace
 * @date 2025/04/05
 * @file M1863_找出所有子集的异或总和再求和.java
 * <p>
 * 思路
 * 求所有元素按位或 * 2^(n - 1)
 */
public class M1863_找出所有子集的异或总和再求和 {
    public int subsetXORSum(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x |= num;
        }

        return x << (nums.length - 1);
    }
}
