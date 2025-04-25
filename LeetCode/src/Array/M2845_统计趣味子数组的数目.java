package Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2025/04/25
 * @file M2845_统计趣味子数组的数目.java
 * <p>
 * 思路
 * 模拟，前缀和
 * 思路和常见的哈希降维是相似的
 */
public class M2845_统计趣味子数组的数目 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            if (pre[i] >= k) {
                ans += mp.getOrDefault((pre[i] - k) % modulo, 0);
            }
            mp.merge(pre[i] % modulo, 1, Integer::sum);
        }

        return ans;
    }

    public long countInterestingSubarrays2(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }
        int[] cnt = new int[Math.min(n + 1, modulo)];
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            if (pre[i] >= k) {
                ans += cnt[(pre[i] - k) % modulo];
            }
            cnt[pre[i] % modulo]++;
        }

        return ans;
    }

    public long countInterestingSubarrays3(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] cnt = new int[Math.min(n + 1, modulo)];
        cnt[0] = 1;
        long ans = 0;
        int pre = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                pre++;
            }
            if (pre >= k) {
                ans += cnt[(pre - k) % modulo];
            }
            cnt[pre % modulo]++;
        }

        return ans;
    }
}
