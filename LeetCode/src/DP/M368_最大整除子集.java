package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/04/06
 * @file M368_最大整除子集.java
 * <p>
 * 思路
 * 1. 记忆化搜索
 * 2. DP
 */
public class M368_最大整除子集 {
    private final int N = 1010;
    private int[] memo = new int[N], from = new int[N];

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Arrays.fill(from, -1);
        int maxF = 0, maxI = 0;
        for (int i = 0; i < n; i++) {
            int f = dfs(i, nums);
            if (f > maxF) {
                maxF = f;
                maxI = i;
            }
        }
        List<Integer> res = new ArrayList<>(maxF);
        for (int i = maxI; i >= 0; i = from[i]) {
            res.add(nums[i]);
        }

        return res;
    }

    private int dfs(int i, int[] nums) {
        if (memo[i] > 0) {
            return memo[i];
        }
        int ans = 0;
        for (int j = 0; j < i; j++) {
            if (nums[i] % nums[j] != 0) {
                continue;
            }
            int f = dfs(j, nums);
            if (f > ans) {
                ans = f;
                from[i] = j;
            }
        }

        return memo[i] = ans + 1;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n], from = new int[n];
        Arrays.fill(from, -1);
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[j] > f[i]) {
                    f[i] = f[j];
                    from[i] = j;
                }
            }
            if (++f[i] > f[maxI]) {
                maxI = i;
            }
        }
        List<Integer> res = new ArrayList<>(f[maxI]);
        for (int i = maxI; i >= 0; i = from[i]) {
            res.add(nums[i]);
        }

        return res;
    }
}
