package Array;

import java.util.*;

/**
 * @author Hyper
 * @date 2024/07/23
 * @file M3098_求出所有子序列的能量和.java
 * <p>
 * 思路
 * 先根据k划分子数组 递归
 * 在每个子数组中，找最接近的两数之差的绝对值 贪心/排序
 * 1. dfs 382/549 MLE了。。
 * 2. 记忆化搜索
 */
public class M3098_求出所有子序列的能量和 {
    final int MOD = (int) (1e9 + 7);
    List<List<Integer>> path = new ArrayList<>();
    int[] nums;
    int k;

    public int sumOfPowers(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        dfs(0, new ArrayList<>());
        int ans = 0;
        for (List<Integer> li : path) {
            Collections.sort(li);
            int diff = Integer.MAX_VALUE;
            for (int i = 1; i < li.size(); i++) {
                diff = Math.min(diff, li.get(i) - li.get(i - 1));
            }
            ans = (ans + diff) % MOD;
        }

        return ans;
    }

    private void dfs(int i, List<Integer> li) {
        if (li.size() == k) {
            path.add(new ArrayList<>(li));
            return;
        }
        if (i == nums.length) {
            return;
        }
        li.add(nums[i]);
        dfs(i + 1, li);
        li.remove(li.size() - 1);
        dfs(i + 1, li);
    }

    private Map<Long, Integer> mp = new HashMap<>();

    public int sumOfPowers2(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;

        return dfs(0, nums.length, k, Integer.MAX_VALUE);
    }

    private int dfs(int i, int j, int k, int mi) {
        if (i >= nums.length) {
            return k == 0 ? mi : 0;
        }
        if (nums.length - i < k) {
            return 0;
        }
        long key = ((long) mi) << 18 | ((long) i << 12) | ((long) j << 6) | k;
        if (mp.containsKey(key)) {
            return mp.get(key);
        }
        int ans = dfs(i + 1, j, k, mi);
        if (j == nums.length) {
            ans += dfs(i + 1, i, k - 1, mi);
        } else {
            ans += dfs(i + 1, i, k - 1, Math.min(mi, nums[i] - nums[j]));
        }
        ans %= MOD;
        mp.put(key, ans);

        return ans;
    }
}
