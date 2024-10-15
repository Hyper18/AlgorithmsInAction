package DP.Knapsack;

/**
 * @author Hyperspace
 * @date 2022/11/01，2024/10/14
 * <p>
 * 思路@Missionary
 * 01背包
 * 1. 状态表示
 * 集合：f[i][j]表示到第i层楼梯时，扔出j个鸡蛋所能确定的安全楼层数目
 * 属性：cnt
 * 2. 状态计算
 * 分类讨论：
 * 1）鸡蛋不破，情况为少1次操作数，所能确定的楼层
 * f[i][cnt] = f[i][cnt - 1]
 * 2）鸡蛋破碎，情况为少1个蛋，少1次操作数，所能确定的楼层
 * f[i][cnt] = f[i - 1][cnt - 1]
 * 加上本次操作确定了当前层，有
 * f[i][cnt] = f[i][cnt - 1] + f[i - 1][cnt - 1] + 1;
 */
public class Q887_鸡蛋掉落 {
    public int superEggDrop(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[] f = new int[k + 1];
        int cnt = 0;
        while (f[k] < n) {
            cnt++;
            for (int i = k; i >= 1; i--) {
                f[i] = f[i] + f[i - 1] + 1;
            }
        }

        return cnt;
    }

    public int superEggDrop2(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[][] f = new int[k + 1][n + 1];
        int cnt = 0;
        while (f[k][cnt] < n) {
            cnt++;
            for (int i = k; i >= 1; i--) {
                f[i][cnt] = f[i][cnt - 1] + f[i - 1][cnt - 1] + 1;
            }
        }

        return cnt;
    }
}
