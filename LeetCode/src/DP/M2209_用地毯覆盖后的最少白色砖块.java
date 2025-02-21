package DP;

/**
 * @author Hyper
 * @date 2025/02/21
 * @file M2209_用地毯覆盖后的最少白色砖块.java
 * <p>
 * 思路
 * 前缀和+DP
 * 1. 状态表示
 * 集合：f[i][j]表示在使用第i张地毯覆盖后在下标j处的最少白色砖块数目
 * 属性：min
 * 2. 状态计算
 * 1) 消耗地毯覆盖
 * 只考虑从当前下标位置铺地毯，即假设当前下标为j，向左侧铺至 j - carpetLen
 * f[i][j] = f[i - 1][j - carpetLen]
 * 2) 不消耗地毯覆盖
 * f[i][j] = f[i][j - 1] + s[j - 1]
 * 综上，状态转移方程为
 * f[i][j] = min(f[i - 1][j - carpetLen], f[i][j - 1] + s[j - 1])
 * <p>
 * 注意数组越界
 * 关于dp时存储的先后顺序，由于本题的数值范围均给定到1000
 * 因此先n和先numCarpets都是一样的
 */
public class M2209_用地毯覆盖后的最少白色砖块 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char[] s = floor.toCharArray();
        int n = s.length;
        if (n <= numCarpets * carpetLen) {
            return 0;
        }
        int[][] f = new int[numCarpets + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            f[0][j] = f[0][j - 1] + s[j - 1] - '0';
        }
        for (int i = 1; i <= numCarpets; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.min(f[i - 1][Math.max(0, j - carpetLen)], f[i][j - 1] + s[j - 1] - '0');
            }
        }

        return f[numCarpets][n];
    }
}
