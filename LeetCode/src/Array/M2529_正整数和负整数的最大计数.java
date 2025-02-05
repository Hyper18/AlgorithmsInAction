package Array;

/**
 * @author Hyper
 * @date 2024/04/09
 * @file M2529_正整数和负整数的最大计数.java
 * <p>
 * 思路
 * 裸，不想写普通计数了，整个活
 */
public class M2529_正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            ans += num > 0 ? 1 : 0;
            n -= num == 0 ? 1 : 0;
        }

        return Math.max(ans, n - ans);
    }
}
