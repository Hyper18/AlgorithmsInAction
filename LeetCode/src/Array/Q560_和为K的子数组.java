package Array;

/**
 * @author Hyper
 * @date 2022/02/27
 * <p>
 * 思路
 * 1. 模拟 -- O(n^2)
 * 2. 前缀和 -- O(n^2)
 */
public class Q560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int[] preSums = new int[n + 1];
        preSums[0] = 0;

        for (int i = 0; i < n; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (preSums[j + 1] - preSums[i] == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
