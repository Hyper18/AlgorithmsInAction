package DP;

/**
 * @author Hyperspace
 * @date 2024/11/01
 * @file M3259_超级饮料的最大强化能量.java
 * <p>
 * 思路
 * DP状态机
 * f[i][0] = max(f[i - 1][0], f[i - 2][1]) + energyDrinkA[i]
 * f[i][1] = max(f[i - 1][1], f[i - 2][0]) + energyDrinkB[i]
 */
public class M3259_超级饮料的最大强化能量 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] f = new long[n][2];
        f[0][0] = energyDrinkA[0];
        f[1][0] = f[0][0] + energyDrinkA[1];
        f[0][1] = energyDrinkB[0];
        f[1][1] = f[0][1] + energyDrinkB[1];
        for (int i = 2; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 2][1]) + energyDrinkA[i];
            f[i][1] = Math.max(f[i - 1][1], f[i - 2][0]) + energyDrinkB[i];
        }

        return Math.max(f[n - 1][0], f[n - 1][1]);
    }
}
