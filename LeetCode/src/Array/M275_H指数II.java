package Array;

/**
 * @author Hyper
 * @date 2023/10/30，2025/03/25
 * @file M275_H指数II.java
 * <p>
 * 思路
 * 1. 模拟，同M274 -- O(n)
 * 2. 闭区间二分 -- O(nlog_n)
 * 找符合的开始位置，记作 st
 * 此时符合部分的长度为 [st, n - 1]
 * 长度为 (n - 1) - (st - 1) = n - st
 * 3. 闭区间二分优化 -- O(log_n)
 * 两种写法，可以枚举索引，也可以枚举 h
 */
public class M275_H指数II {
    public int hIndex(int[] citations) {
        if (citations.length == 1) {
            return citations[0] >= 1 ? 1 : 0;
        }
        int n = citations.length;
        for (int i = 1; i <= n; i++) {
            if (citations[n - i] < i) {
                return i - 1;
            }
        }

        return n;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        for (int i = n; i > 0; i--) {
            int st = binarySearch(citations, i);
            if (n - st >= i) {
                return i;
            }
        }

        return 0;
    }

    private int binarySearch(int[] nums, int target) {
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

    public int hIndex3_0(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1, st = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (citations[mid] < n - mid) {
                low = mid + 1;
            } else {
                st = mid;
                high = mid - 1;
            }
        }

        return n - st;
    }

    public int hIndex3_1(int[] citations) {
        int n = citations.length;
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (citations[n - mid] >= mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}
