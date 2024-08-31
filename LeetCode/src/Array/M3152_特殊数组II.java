package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/08/14
 * @file M3152_特殊数组II.java
 * <p>
 * 思路
 * 前缀和
 */
public class M3152_特殊数组II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{2, 3}})));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length, len = queries.length;
        int[] pre = new int[n];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] % 2 == nums[i - 1] % 2 ? pre[i - 1] + 1 : pre[i - 1];
        }
        boolean[] res = new boolean[len];
        int i = 0;
        for (int[] q : queries) {
            res[i++] = pre[q[1]] - pre[q[0]] == 0;
        }

        return res;
    }
}
