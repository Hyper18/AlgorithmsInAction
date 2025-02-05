package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/04/08
 * @file M2009_使数组连续的最少操作数.java
 * <p>
 * 思路
 * 双指针
 * 先升序排序后去重，得到新的数组长度为len
 * 最后依次找最大长度，用现在的数组长度len减去无需调整的部分r - l
 * 得到最小操作数
 * <p>
 * 注：
 * 1) 依照题意，操作数最大不会超过数组长度
 * 2) 去重学习了一种比较优雅的做法，直接在原数组上去重。多余部分后续不使用
 * 3) 也可以考虑二分
 */
public class M2009_使数组连续的最少操作数 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[len++] = nums[i];
            }
        }
        int ans = n;
        for (int l = 0, r = 0; r < len; l++) {
            while (r < len && nums[r] - nums[l] <= n - 1) {
                r++;
            }
            ans = Math.min(ans, n - r + l);
        }

        return ans;
    }
}
