package DP.Knapsack;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/03/19，2025/04/07
 * 1. 01背包问题
 * 首先找dp含义
 * 对原模型
 * f[i][j] 表示
 * 外层循环表示从遍历物品
 * 内层循环表示从背包容量 ~ 能装入最小物品的容量
 * <p>
 * 而对于本问题，背包容量为数组所有元素和的一半
 * 结合“两个子集的元素和相等”的描述，为恰等于背包容量
 * <p>
 * 还可以直接把 f 设为布尔数组，以压缩空间占用
 * 初始化 f[i = 0]
 * <p>
 * 还可以对时间复杂度做进一步优化：
 * 当数组中的最大数仍比一半大（大于背包容量）时
 * 直接返回 false
 * <p>
 * 2. BitSet空间优化
 */
public class Q416_分割等和子集 {
    public boolean canPartition1_0(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int n = sum >> 1;
        int[] f = new int[n + 1];
        for (int num : nums) {
            for (int i = n; i >= num; i--) {
                f[i] = Math.max(f[i], f[i - num] + num);
            }
        }

        return f[n] == n;
    }

    public boolean canPartition1_1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int n = sum >> 1;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int num : nums) {
            for (int i = n; i >= num; i--) {
                f[i] = f[i] | f[i - num];
            }
        }

        return f[n];
    }

    public boolean canPartition1_2(int[] nums) {
        int sum = 0, mx = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            mx = num > mx ? num : mx;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = sum / 2;
        if (mx > n) {
            return false;
        }
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int num : nums) {
            for (int i = n; i >= num; i--) {
                f[i] = f[i] | f[i - num];
            }
        }

        return f[n];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum >>= 1;
        BigInteger f = BigInteger.ONE;
        for (int num : nums) {
            f = f.or(f.shiftLeft(num));
        }

        return f.testBit(sum);
    }
}
