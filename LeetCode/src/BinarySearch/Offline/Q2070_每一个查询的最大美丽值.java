package BinarySearch.Offline;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hyperspace
 * @date 2024/12/16
 * @file Q2070_每一个查询的最大美丽值.java
 * <p>
 * 思路
 * 模拟+离线二分
 * 对queries和items升序排序
 * 依次找恰好满足价格小于等于queries[j]而美丽值最大的下标
 * 故排序时需要让items中遇到价格相等的情况时，升序排列美丽值
 */
public class Q2070_每一个查询的最大美丽值 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length, k = queries.length;
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < n; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        int[][] myQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            myQueries[i][0] = i;
            myQueries[i][1] = queries[i];
        }
        Arrays.sort(myQueries, Comparator.comparingInt(a -> a[1]));
        int[] res = new int[k];
        for (int[] q : myQueries) {
            int idx = q[0], mx = q[1], pos = binarySearch(items, mx);
            if (pos >= 0) {
                res[idx] = items[pos][1];
            }
        }

        return res;
    }

    private int binarySearch(int[][] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid][0] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }
}
