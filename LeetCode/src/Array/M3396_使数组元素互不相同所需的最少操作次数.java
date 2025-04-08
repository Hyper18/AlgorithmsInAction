package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/04/08
 * @file M3396_使数组元素互不相同所需的最少操作次数.java
 * <p>
 * 思路
 * 1. 模拟
 * 写了一种类似滑窗的思路
 * 但是由于本题限定了只能由最前面开始删除
 * 这就导致了如果删除前3个元素后
 * 会出现 set 中仍有重复元素的情况
 * 因此这种写法的时间复杂度是 O(n^2) 的
 * 2. 模拟优化
 * 逆序遍历 -- O(n)
 */
public class M3396_使数组元素互不相同所需的最少操作次数 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (!st.add(nums[r])) {
                while (st.contains(nums[r])) {
                    int cnt = 3;
                    while (cnt > 0 && l < n) {
                        st.remove(nums[l++]);
                        cnt--;
                    }
                    ans++;
                }
                if (l > r) {
                    r = l - 1;
                    continue;
                }
                st.add(nums[r]);
            }
        }

        return ans;
    }

    private final int N = 103;

    public int minimumOperations2(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[N];
        for (int i = n - 1; i >= 0; i--) {
            if (vis[nums[i]]) {
                return i / 3 + 1;
            }
            vis[nums[i]] = true;
        }

        return 0;
    }
}
