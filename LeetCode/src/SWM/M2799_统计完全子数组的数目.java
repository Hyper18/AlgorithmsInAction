package SWM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/04/24
 * @file M2799_统计完全子数组的数目.java
 * <p>
 * 思路
 * 不定长SWM
 */
public class M2799_统计完全子数组的数目 {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int cnt = st.size();
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            mp.merge(nums[r], 1, Integer::sum);
            while (mp.size() == cnt) {
                mp.merge(nums[l], -1, Integer::sum);
                if (mp.get(nums[l]) == 0) {
                    mp.remove(nums[l]);
                }
                l++;
            }
            ans += l;
        }

        return ans;
    }

    private final int N = 2010;

    public int countCompleteSubarrays2(int[] nums) {
        int n = nums.length;
        int[] mp = new int[N];
        int cnt = 0;
        for (int i : nums) {
            if (mp[i]++ == 0) {
                cnt++;
            }
        }
        int ans = 0, cur = 0;
        mp = new int[N];
        for (int l = 0, r = 0; r < n; r++) {
            if (mp[nums[r]]++ == 0) {
                cur++;
            }
            while (cur == cnt) {
                if (--mp[nums[l]] == 0) {
                    cur--;
                }
                l++;
            }
            ans += l;
        }

        return ans;
    }
}
