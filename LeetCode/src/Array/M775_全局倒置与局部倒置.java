package Array;

/**
 * @author Hyper
 * @date 2022/11/16
 * @file M775_全局倒置与局部倒置.java
 * <p>
 * 思路
 * 暴力（很明显会TLE）
 * 优化
 * 反向遍历，看是否有隔着超过一个元素的前面的值大于后面的值
 */
public class M775_全局倒置与局部倒置 {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    ans++;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                ans--;
            }
        }

        return ans == 0;
    }

    public boolean isIdealPermutation2(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(min, nums[i + 1]);
        }

        return true;
    }
}
