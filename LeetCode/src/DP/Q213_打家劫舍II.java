package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/08，2023/09/17
 * dp -- O(n)
 * 对比Q198，主要问题在于环的解决
 * 一开始考虑设置标志位，首位选择则末位不选，反之亦然（若需要时，择较大者）
 * 后发现容易地确定选取首或尾的情况
 * <p>
 * 考虑将环拆分为两个独立的线段
 * 第一段包含从首个元素到末位元素的前一个元素
 * 第二段包含首个元素后的所有元素
 * 并利用Q198思路遍历两次
 */
public class Q213_打家劫舍II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return max(subRob(Arrays.copyOf(nums, n - 1)), subRob(Arrays.copyOfRange(nums, 1, n)));
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int subRob(int[] nums) {
        int tmp, pre = 0, cur = 0;
        for (int num : nums) {
            tmp = max(cur, pre + num);
            pre = cur;
            cur = tmp;
        }

        return cur;
    }
}
