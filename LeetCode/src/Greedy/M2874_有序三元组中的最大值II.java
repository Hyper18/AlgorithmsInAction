package Greedy;

/**
 * @author Hyperspace
 * @date 2025/04/02
 * @file M2874_有序三元组中的最大值II.java
 * <p>
 * 思路
 * 贪心
 * 同Q2873
 */
public class M2874_有序三元组中的最大值II {
    public long maximumTripletValue(int[] nums) {
        long ans = 0, diff = 0, pre = 0;
        for (int num : nums) {
            ans = Math.max(ans, diff * num);
            diff = Math.max(diff, pre - num);
            pre = Math.max(pre, num);
        }

        return ans;
    }
}
