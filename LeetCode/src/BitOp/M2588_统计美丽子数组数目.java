package BitOp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2025/03/06
 * @file M2588_统计美丽子数组数目.java
 * <p>
 * 思路
 * 前缀和+位运算
 * 主要思想是利用异或一圈为0的性质
 * Q560同类题
 */
public class M2588_统计美丽子数组数目 {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ nums[i - 1];
        }
        Map<Integer, Integer> mp = new HashMap<>(n + 1);
        for (int x : pre) {
            ans += mp.merge(x, 1, Integer::sum);
        }

        return ans;
    }
}
