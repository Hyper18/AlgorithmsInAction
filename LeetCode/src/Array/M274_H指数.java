package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/10/29，2025/03/25
 * @file M274_H指数.java
 * <p>
 * 思路
 * 1. 模拟 -- O(n)
 * 升序排序
 * 从1开始遍历被引用次数i
 * 寻找此时对应的论文数目，若不超过i本
 * 则返回结果i - 1
 * <p>
 * 注：需要特判n = 1的情况
 * <p>
 * 2. 排序+闭区间二分 -- O(nlog_n)
 */
public class M274_H指数 {
    public int hIndex(int[] citations) {
        if (citations.length == 1) {
            return citations[0] >= 1 ? 1 : 0;
        }
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 1; i <= n; i++) {
            if (citations[n - i] < i) {
                return i - 1;
            }
        }

        return n;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
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
