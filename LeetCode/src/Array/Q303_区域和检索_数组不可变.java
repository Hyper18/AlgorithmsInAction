package Array;

/**
 * @author Hyperspace
 * @date 2022/02/26
 * <p>
 * 思路
 * 前缀和 -- 初始化 O(n)，每次检索 O(1)
 * 使用一个一维数组 sums 来记录前缀和
 * 初始化需要遍历数组 nums 计算前缀和
 * 又因为每sumRange方法会被多次调用，因此应尽量降低该方法的时间复杂度
 */
public class Q303_区域和检索_数组不可变 {
    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }
}
