package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/10/27
 * @file M1465_切割后面积最大的蛋糕.java
 * <p>
 * 思路
 * 贪心
 * 首先对长和宽进行升序排序
 * 遍历，找最大长和宽相乘取模
 * <p>
 * 注意爆int
 */
public class M1465_切割后面积最大的蛋糕 {
    final int MOD = (int) 1e9 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        return (int) ((long) getMax(horizontalCuts, h) * getMax(verticalCuts, w) % MOD);
    }

    private int getMax(int[] nums, int len) {
        int ans = 0, pre = 0;
        for (int num : nums) {
            ans = Math.max(ans, num - pre);
            pre = num;
        }

        return Math.max(ans, len - pre);
    }
}
