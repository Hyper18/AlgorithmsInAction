package BinarySearch.Offline;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/02/14
 * @file M1552_两球之间的磁力.java
 * <p>
 * 思路
 * 排序+开区间二分，最大化最小值
 */
public class M1552_两球之间的磁力 {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1, high = position[n - 1];
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (check(position, mid, m)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean check(int[] position, int distance, int m) {
        int cnt = 1, pre = position[0];
        for (int pos : position) {
            if (pos - pre >= distance) {
                cnt++;
                pre = pos;
            }
        }

        return cnt >= m;
    }
}
