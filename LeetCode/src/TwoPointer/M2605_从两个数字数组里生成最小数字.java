package TwoPointer;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/09/05
 * @file M2605_从两个数字数组里生成最小数字.java
 * <p>
 * 思路
 * 模拟，双指针
 * 题干很绕，可参考评论区解释，或见英文：
 * return the smallest number that contains at least one digit from each array.
 * 分类讨论
 * 1) 两数组均存在共同的最小数字，直接返回
 * 2) 两数组不存在共同的最小数字，各取一个数组成一个最小数字
 */
public class M2605_从两个数字数组里生成最小数字 {
    public int minNumber(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return nums1[0] < nums2[0] ? nums1[0] * 10 + nums2[0] : nums2[0] * 10 + nums1[0];
    }
}
