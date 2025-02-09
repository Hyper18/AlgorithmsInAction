package TwoPointer;

/**
 * @author Hyper
 * @date 2025/02/09
 * @file Q26_删除有序数组中的重复项.java
 * <p>
 * 思路
 * 1. 模拟 -- O(n^2)
 * 2. 双指针 -- O(n)
 */
public class Q26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                n--;
                i--;
            }
        }

        return n;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int l = 1;
        for (int r = 1; r < n; r++) {
            if (nums[r] != nums[r - 1]) {
                nums[l++] = nums[r];
            }
        }

        return l;
    }
}
