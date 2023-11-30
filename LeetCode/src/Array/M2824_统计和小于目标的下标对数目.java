package Array;

import java.util.List;

/**
 * @author Hyperspace
 * @date 2023/11/24
 * @file M2824_统计和小于目标的下标对数目.java
 * <p>
 * 思路
 * 模拟
 */
public class M2824_统计和小于目标的下标对数目 {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
