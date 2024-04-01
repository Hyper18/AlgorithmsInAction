package Array;

/**
 * @author Hyperspace
 * @date 2024/03/18
 * @file M303_区域和检索_数组不可变.java
 * <p>
 * 思路
 * 前缀和裸题
 */
public class M303_区域和检索_数组不可变 {
    class NumArray {
        int[] pre;

        public NumArray(int[] nums) {
            int n = nums.length;
            pre = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pre[i] = pre[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return pre[right + 1] - pre[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
