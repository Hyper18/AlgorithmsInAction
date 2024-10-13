package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/10/13
 * @file M1884_鸡蛋掉落_两枚鸡蛋.java
 * <p>
 * 思路
 * DP
 * 1. 状态表示
 * 集合：f[i]表示i层建筑的最小操作次数
 * 属性：min
 * 2. 状态计算
 * 令投下的位置为j，分类讨论如下：
 * (1) 从第j层投下碎了
 * f位于[0, j - 1]
 * 此时只能使用第二颗依次从小到大尝试j - 1次
 * 合计1 + (j - 1) = j次
 * (2) 从第j层投下不碎
 * f位于[j, i]
 * f[i] = f[i - j] + 1
 * <p>
 * 故有
 * f[i] = min(f[i], max(j - 1, f[i - j]) + 1)
 */
public class M1884_鸡蛋掉落_两枚鸡蛋 {
    private final int N = 1010;
    private int[] f = new int[N];

    public int twoEggDrop(int n) {
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] = Math.min(f[i], Math.max(j - 1, f[i - j]) + 1);
            }
        }

        return f[n];
    }
}
