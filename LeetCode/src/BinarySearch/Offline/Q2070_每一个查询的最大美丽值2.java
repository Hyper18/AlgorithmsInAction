package BinarySearch.Offline;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/12/16
 * @file Q2070_每一个查询的最大美丽值.java
 * <p>
 * 思路
 * 模拟+离线二分优化
 * 对items升序排序
 * 依次找恰好满足价格小于等于queries[j]而美丽值最大的下标
 * queries可以不排序，对于本题，查询的先后顺序不影响items这边的结果
 */
public class Q2070_每一个查询的最大美丽值2 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length, k = queries.length;
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < n; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int pos = binarySearch(items, queries[i]);
            if (pos >= 0) {
                res[i] = items[pos][1];
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
