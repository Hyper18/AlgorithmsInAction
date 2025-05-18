package TwoPointer;

/**
 * @author Hyperspace
 * @date 2025/05/17
 * @file M75_颜色分类.java
 * <p>
 * 思路
 * 1. 排序，两次遍历
 * 2. 双指针
 */
public class M75_颜色分类 {
    class Solution {
        private int[] nums;

        public void sortColors(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    swap(i, idx++);
                }
            }
            for (int i = idx; i < n; i++) {
                if (nums[i] == 1) {
                    swap(i, idx++);
                }
            }
        }

        private void swap(int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    class Solution2 {
        private int[] nums;

        public void sortColors(int[] nums) {
            int n = nums.length;
            this.nums = nums;
            int l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    swap(i, l);
                    if (l < r) {
                        swap(i, r);
                    }
                    l++;
                    r++;
                } else if (nums[i] == 1) {
                    swap(i, r++);
                }
            }
        }

        private void swap(int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
