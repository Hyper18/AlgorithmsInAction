package Greedy;

/**
 * @author Hyperspace
 * @date 2025/07/16
 * @file M3201_找出有效子序列的最大长度I.java
 * <p>
 * 思路
 * 贪心
 * 实质上考虑奇偶交替的特性即可，去除重复元素
 */
public class M3201_找出有效子序列的最大长度I {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 1;
        boolean last = false;
        for (int i = 0; i < n; i++) {
            boolean flag = nums[i] % 2 == 0;
            cnt1 += flag ? 0 : 1;
            if (i == 0) {
                last = flag;
            } else if (last != flag) {
                cnt2++;
                last = flag;
            }
        }

        return Math.max(Math.max(n - cnt1, cnt1), cnt2);
    }
}
