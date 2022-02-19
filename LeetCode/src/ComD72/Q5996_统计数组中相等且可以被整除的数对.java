package ComD72;

/**
 * @author Hyperspace
 * @date 2022/02/19
 */
public class Q5996_统计数组中相等且可以被整除的数对 {
    public int countPairs(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
