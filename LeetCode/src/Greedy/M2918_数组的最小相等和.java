package Greedy;

/**
 * @author Hyperspace
 * @date 2025/05/10
 * @file M2918_数组的最小相等和.java
 * <p>
 * 思路
 * 贪心
 * 本质就是在补1
 * 去掉不可能的情况
 * <p>
 * 注意爆int
 */
public class M2918_数组的最小相等和 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        boolean hasZeros1 = false, hasZeros2 = false;
        for (int num : nums1) {
            if (num == 0) {
                sum1++;
                hasZeros1 = true;
                continue;
            }
            sum1 += num;
        }
        for (int num : nums2) {
            if (num == 0) {
                sum2++;
                hasZeros2 = true;
            }
            sum2 += num;
        }
        if ((sum1 > sum2 && !hasZeros2) || (sum2 > sum1 && !hasZeros1)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}
