package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/02/27，2025/02/07，2025/03/06
 * <p>
 * 思路
 * 1. 模拟 -- O(n^2)
 * 可以看到由于num可为负数，故无法用SWM
 * 因此考虑前缀和
 * 2. 前缀和 -- O(n^2)
 * O(n^2)如何优化？@灵茶山艾府
 * 引入哈希记录当前前缀和与左侧前缀和的和为k的个数
 * 3. 前缀和+哈希 -- O(n)
 * 较优解
 */
public class Q560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int st = 0; st < n; st++) {
            int sum = 0;
            for (int ed = st; ed >= 0; ed--) {
                sum += nums[ed];
                if (sum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int subarraySum2_0(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pre[j] - pre[i] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int subarraySum2_1(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (pre[j] - pre[i] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>(n + 1);
        for (int i : pre) {
            ans += mp.getOrDefault(i - k, 0);
            mp.merge(i, 1, Integer::sum);
        }

        return ans;
    }
}
