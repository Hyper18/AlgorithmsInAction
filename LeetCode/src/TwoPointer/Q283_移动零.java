package TwoPointer;

/**
 * @author Hyperspace
 * @date 2022/02/13
 * <p>
 * 思路
 * 1. 双指针，类似冒泡 -- O(n)
 */
public class Q283_移动零 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int p1 = 0;
        int p2 = 0;
        while (p2 < len) {
            if (nums[p2] != 0) {
                swap(nums, p1, p2);
                p1++;
            }
            p2++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
