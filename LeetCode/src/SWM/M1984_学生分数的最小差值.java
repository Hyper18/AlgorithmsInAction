package SWM;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/11
 * 思路
 * 滑动窗口，k作为窗口宽度
 * 为降低一组数据中最大和最小值的差值，先为数组排序，再以一组batch遍历
 * 这样则只需比较这组值中的头尾两值，顺次作差比较得到最小差值
 */
public class M1984_学生分数的最小差值 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }
}
