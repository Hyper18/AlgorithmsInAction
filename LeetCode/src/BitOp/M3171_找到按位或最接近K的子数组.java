package BitOp;

/**
 * @author Hyper
 * @date 2024/10/09
 * @file M3171_找到按位或最接近K的子数组.java
 * <p>
 * 思路@灵茶山艾府
 * 位运算
 * <p>
 * 1. 枚举 TLE
 * 2. LogTrick 优化
 * 第一次看到这个做法
 * 对于两个二进制数a和b，如果a|b=a，那么b对应的集合是a对应的集合的子集
 */
public class M3171_找到按位或最接近K的子数组 {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            ans = Math.min(ans, Math.abs(t - k));
            for (int j = i - 1; j >= 0; j--) {
                nums[j] |= t;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }

        return ans;
    }

    public int minimumDifference2(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            ans = Math.min(ans, Math.abs(t - k));
            for (int j = i - 1; j >= 0 && (nums[j] | t) != nums[j]; j--) {
                nums[j] |= t;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }

        return ans;
    }
}
