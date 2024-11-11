package DP.ScopeDP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/11/11
 * @file Q312_戳气球.java
 * <p>
 * 思路
 * 1. dfs + 记忆化
 * 2. 区间DP
 * 逆向地考虑，每次选取一个气球k加入
 * 初始化时，最左端和最右端的值由题干均为1
 * 此时向区间[i, j]加入该气球的贡献为a[i] * a[k] * a[j]
 * 往复，则每次的贡献为
 * k左侧气球的贡献 + 新加入k的贡献 + k右侧气球的贡献
 * <p>
 * f[i][j] = max(f[i][j], f[i][k] + f[k][j] + a[i] * a[k] * a[j])
 * 注：
 * (1) 为了规避数组越界，将新数组的长度设置为原数组长度 + 左边界 + 右边界
 * (2) 逆序遍历添加位置，是为了使此时使用的f[i][k]，f[k][j]均为已更新的值
 */
public class Q312_戳气球 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int len = n + 2;
        int[] a = new int[len];
        int[][] f = new int[len][len];
        a[0] = a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }

        return dfs(f, a, 0, len - 1);
    }

    private int dfs(int[][] f, int[] a, int l, int r) {
        if (l >= r - 1) {
            return 0;
        }
        if (f[l][r] != -1) {
            return f[l][r];
        }
        for (int k = l + 1; k < r; k++) {
            f[l][r] = Math.max(f[l][r], dfs(f, a, l, k) + dfs(f, a, k, r) + a[l] * a[k] * a[r]);
        }

        return f[l][r];
    }

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        int len = n + 2;
        int[] a = new int[len];
        int[][] f = new int[len][len];
        a[0] = a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + a[i] * a[k] * a[j]);
                }
            }
        }

        return f[0][len - 1];
    }
}
