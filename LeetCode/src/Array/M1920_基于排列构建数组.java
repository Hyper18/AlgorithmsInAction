package Array;

/**
 * @author Hyper
 * @date 2025/05/06
 * @file M1920_基于排列构建数组.java
 */
public class M1920_基于排列构建数组 {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[nums[i]];
        }

        return res;
    }
}
