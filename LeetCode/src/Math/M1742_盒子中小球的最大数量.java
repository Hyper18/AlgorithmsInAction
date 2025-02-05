package Math;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/11/23
 * @file M1742_盒子中小球的最大数量.java
 * <p>
 * 思路
 * 1. 模拟
 * 给定10^5 最大需要9*5 = 45编号空间
 * 对于每一个i 每次取一位，累加和得到盒子编号
 */
public class M1742_盒子中小球的最大数量 {
    int[] f = new int[50];

    public int countBalls(int lowLimit, int highLimit) {
        for (int i = lowLimit; i <= highLimit; i++) {
            f[getNum(i)]++;
        }

        return Arrays.stream(f).max().getAsInt();
    }

    int getNum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }

        return ans;
    }
}
