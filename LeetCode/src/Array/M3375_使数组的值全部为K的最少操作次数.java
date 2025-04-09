package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/04/09
 * @file M3375_使数组的值全部为K的最少操作次数.java
 * <p>
 * 思路
 * 模拟
 */
public class M3375_使数组的值全部为K的最少操作次数 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                st.add(num);
            }
        }

        return st.size();
    }

    private final int N = 103;

    public int minOperations2(int[] nums, int k) {
        boolean[] vis = new boolean[N];
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k && !vis[num]) {
                ans++;
                vis[num] = true;
            }
        }

        return ans;
    }

    public int minOperations3(int[] nums, int k) {
        int mn = Arrays.stream(nums).min().getAsInt();
        if (k > mn) {
            return -1;
        }
        return (int) Arrays.stream(nums).distinct().count() - (k == mn ? 1 : 0);
    }
}
