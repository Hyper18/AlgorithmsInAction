package TwoPointer;

/**
 * @author Hyper
 * @date 2022/02/13，2025/02/05
 * <p>
 * 思路
 * 1. 双指针，两次遍历
 * 2. 双指针，类似冒泡 -- O(n)
 */
public class Q283_移动零 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int l = 0; l < n; l++) {
            if (nums[l] == 0) {
                int r = l + 1;
                while (r < n && nums[r] == 0) {
                    r++;
                }
                if (r < n) {
                    nums[l] = nums[r];
                    nums[r] = 0;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] != 0) {
                int t = nums[r];
                nums[r] = nums[l];
                nums[l++] = t;
            }
        }
    }
}
