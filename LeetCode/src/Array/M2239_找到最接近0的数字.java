package Array;

/**
 * @author Hyperspace
 * @date 2025/01/20
 * @file M2239_找到最接近0的数字.java
 */
public class M2239_找到最接近0的数字 {
    public int findClosestNumber(int[] nums) {
        int diff = Integer.MAX_VALUE, ans = nums[0];
        for (int num : nums) {
            int t = num >= 0 ? num : -num;
            if (t < diff) {
                diff = t;
                ans = num;
            } else if (t == diff && num > ans) {
                ans = num;
            }
        }

        return ans;
    }

    public int findClosestNumber2(int[] nums) {
        int ans = nums[0];
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(ans) || (Math.abs(num) == Math.abs(ans) && num > ans)) {
                ans = num;
            }
        }

        return ans;
    }
}
