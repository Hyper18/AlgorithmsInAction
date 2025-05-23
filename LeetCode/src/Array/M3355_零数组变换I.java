package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/05/20
 * @file M3355_零数组变换I.java
 * <p>
 * 思路
 * 1. 模拟 TLE
 * 2. 差分
 */
public class M3355_零数组变换I {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[1]; i++) {
                if (nums[i] > 0) {
                    nums[i]--;
                }
            }
        }

        return Arrays.stream(nums).sum() == 0;
    }

    public boolean isZeroArray2(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }
        for (int i = 0, sum = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] > sum) {
                return false;
            }
        }

        return true;
    }
}
