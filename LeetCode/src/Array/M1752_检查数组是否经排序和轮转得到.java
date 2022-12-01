package Array;

/**
 * @author Hyperspace
 * @date 2022/11/27
 * @file M1752_检查数组是否经排序和轮转得到.java
 * <p>
 * 思路
 * 模拟
 */
public class M1752_检查数组是否经排序和轮转得到 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                l = i;
                break;
            }
        }
        // 已经为非递减序
        if (l == 0) {
            return true;
        }
        for (int i = l + 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }

        return nums[0] >= nums[n - 1];
    }
}
