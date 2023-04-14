package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2023/03/10
 * @file M1590_使数组和能被P整除.java
 * <p>
 * 思路
 * 先从左到右求前缀和模p的值
 * 此时若数组和模p已为0，则无需调整，可直接返回
 * 由于数组全部替换非法，可先指定ans = n
 * 利用hash依次记录左侧值的idx
 * 这里不用担心有相同情况，因为若相同则覆盖idx为更靠近r指针的位置，长度更短
 * 每次遍历时，找能够使现数组和模p-原数组和模p为0的最靠右的idx位置
 */
public class M1590_使数组和能被P整除 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = (pre[i - 1] + nums[i - 1]) % p;
        }
        int t = pre[n];
        if (t == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = n;
        for (int r = 0; r <= n; r++) {
            map.put(pre[r], r);
            int l = map.getOrDefault((pre[r] - t + p) % p, -n);
            ans = Math.min(ans, r - l);
        }

        return ans == n ? -1 : ans;
    }
}
