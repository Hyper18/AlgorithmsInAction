package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/03/04
 * @file M982_按位与为零的三元组.java
 * <p>
 * 思路
 * 1. 暴力（TLE）
 * 2. dp，记忆化搜索
 * 状态表示
 * 集合：f[i][j]表示i个数相与结果为j的方案个数
 * 属性：cnt
 */
public class M982_按位与为零的三元组 {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((nums[i] & nums[j] & nums[k]) == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public int countTriplets2(int[] nums) {
        int n = nums.length, len = Arrays.stream(nums).max().getAsInt() + 1;
        int[][] f = new int[4][len];
        for (int[] l : f) {
            Arrays.fill(l, -1);
        }

        return dfs(nums, f, 0, 0);
    }

    private int dfs(int[] nums, int[][] f, int cnt, int tot) {
        if (f[cnt][tot] != -1) {
            return f[cnt][tot];
        }
        if (cnt == 3) {
            if (tot == 0) {
                return f[cnt][tot] = 1;
            }
            return 0;
        }
        int ans = 0;
        for (int num : nums) {
            ans += cnt == 0 ? dfs(nums, f, cnt + 1, num) : dfs(nums, f, cnt + 1, tot & num);
        }
        return f[cnt][tot] = ans;
    }
}
