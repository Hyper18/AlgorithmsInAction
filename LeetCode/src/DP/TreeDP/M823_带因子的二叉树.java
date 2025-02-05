package DP.TreeDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/08/29
 * @file M823_带因子的二叉树.java
 * <p>
 * 思路
 * DP，双指针
 * 先排序，则对于arr[i]，其子孙结点只能从[0, i - 1)中选取
 * 双指针定左侧，找最小符合的右侧位置
 * 分类讨论：
 * 1）左子结点和右子结点相等
 * f[i] += f[l] * f[r]
 * 2）左子结点和右子结点不相等，则还多一种交换位置的情况
 * f[i] += 2 * f[l] * f[r]
 * 注意溢出
 */
public class M823_带因子的二叉树 {
    final int N = 1005, MOD = (int) 1e9 + 7;
    long[] f = new long[N];

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int l = 0, r = i - 1; l <= r; l++) {
                while (l <= r && (long) arr[l] * arr[r] > arr[i]) {
                    r--;
                }
                if (l <= r && (long) arr[l] * arr[r] == arr[i]) {
                    f[i] = l == r ? (f[i] + f[l] * f[r]) % MOD : (f[i] + 2 * f[l] * f[r]) % MOD;
                }
            }
            ans = (ans + f[i]) % MOD;
        }

        return (int) ans;
    }
}
