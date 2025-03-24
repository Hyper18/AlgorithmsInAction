package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hyper
 * @date 2023/11/10，2025/03/24
 * @file M2300_咒语和药水的成功对数.java
 * <p>
 * 思路
 * 1. 排序+模拟
 * 2. 排序+闭区间二分
 */
public class M2300_咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = spells[i];
            idx[i][1] = i;
        }
        Arrays.sort(potions);
        for (int i = 0, j = m - 1; i < j; i++, j--) {
            int t = potions[i];
            potions[i] = potions[j];
            potions[j] = t;
        }
        Arrays.sort(idx, Comparator.comparingInt(a -> a[0]));
        for (int i = 0, j = 0; i < n; i++) {
            int p = idx[i][1], v = idx[i][0];
            while (j < m && (long) potions[j] * v >= success) {
                j++;
            }
            res[p] = j;
        }

        return res;
    }

    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int ed = binarySearch(potions, (int) Math.ceil((double) success / spells[i]));
            res[i] = ed == m ? 0 : m - ed;
        }

        return res;
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
