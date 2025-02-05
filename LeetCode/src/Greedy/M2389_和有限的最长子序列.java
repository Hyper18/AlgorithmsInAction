package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/03/17
 * @file M2389_和有限的最长子序列.java
 * <p>
 * 思路
 * 贪心
 * 求满足条件的子数组最大长度
 * 但无需输出符合的子数组
 * 可以直接对原数组递增排序
 * 遍历，每次从左侧开始取最多
 */
public class M2389_和有限的最长子序列 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int num = 0, cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                num += nums[j];
                if (num > queries[i]) {
                    break;
                }
                cnt++;
            }
            ans[i] = cnt;
        }

        return ans;
    }
}
