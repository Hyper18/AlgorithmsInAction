package DP.Knapsack;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/10/26
 * @file M3181_执行操作可获得的最大总奖励II.java
 * <p>
 * 思路
 * DP，位运算
 */
public class M3181_执行操作可获得的最大总奖励II {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        if (n >= 2 && rewardValues[n - 2] == rewardValues[n - 1] - 1) {
            return 2 * rewardValues[n - 1] - 1;
        }
        BigInteger f = BigInteger.ONE;
        for (int x : Arrays.stream(rewardValues).distinct().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(x).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(x));
        }

        return f.bitLength() - 1;
    }
}
