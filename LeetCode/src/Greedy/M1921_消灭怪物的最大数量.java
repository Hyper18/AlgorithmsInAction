package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/09/03
 * @file M1921_消灭怪物的最大数量.java
 * <p>
 * 思路
 * 贪心
 */
public class M1921_消灭怪物的最大数量 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(t);
        for (int i = 0; i < n; i++) {
            if (t[i] <= i) {
                return i;
            }
        }

        return n;
    }
}
