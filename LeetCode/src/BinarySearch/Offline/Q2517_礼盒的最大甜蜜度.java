package BinarySearch.Offline;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/02/14
 * @file Q2517_礼盒的最大甜蜜度.java
 * <p>
 * 思路
 * 排序+开区间二分，最大化最小值
 */
public class Q2517_礼盒的最大甜蜜度 {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int low = 0, high = price[n - 1];
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (check(price, mid, k)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean check(int[] price, int distance, int k) {
        int cnt = 1, pre = price[0];
        for (int p : price) {
            if (p - pre >= distance) {
                cnt++;
                pre = p;
            }
        }

        return cnt >= k;
    }
}
