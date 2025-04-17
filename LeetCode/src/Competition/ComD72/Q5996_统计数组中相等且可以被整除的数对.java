package Competition.ComD72;

/**
 * @author Hyper
 * @date 2022/02/19，2025/04/17
 * <p>
 * 思路
 * 模拟
 */
public class Q5996_统计数组中相等且可以被整除的数对 {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
