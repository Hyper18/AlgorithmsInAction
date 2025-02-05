package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hyper
 * @date 2022/11/15
 * @file M1710_卡车上的最大单元数.java
 * <p>
 * 思路
 * 贪心
 * 排序，依次取完同等体积（1）下的最大单位
 */
public class M1710_卡车上的最大单元数 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        for (int i = n - 1; i >= 0 && truckSize >= 0; i--) {
            int num = boxTypes[i][0], units = boxTypes[i][1];
            ans += truckSize - num >= 0 ? num * units : truckSize * units;
            truckSize -= num;
        }

        return ans;
    }

    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] box : boxTypes) {
            if (truckSize - box[0] >= 0) {
                ans += box[0] * box[1];
            } else {
                ans += truckSize * box[1];
                break;
            }
            truckSize -= box[0];
        }

        return ans;
    }
}
