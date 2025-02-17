package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/02/17
 * @file M1287_有序数组中出现次数超过25的元素.java
 * <p>
 * 思路
 * 模拟
 * 1. 哈希
 * 2. 贪心
 * 由于题目已经给定是逆序，故可直接从头开始计数
 */
public class M1287_有序数组中出现次数超过25的元素 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0, q = n / 4; i < n; i++) {
            if (mp.merge(arr[i], 1, Integer::sum) > q) {
                return arr[i];
            }
        }

        return -1;
    }

    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int cnt = 0, pre = arr[0], q = n / 4;
        for (int x : arr) {
            if (x == pre) {
                if (++cnt > q) {
                    return x;
                }
            } else {
                pre = x;
                cnt = 1;
            }
        }

        return -1;
    }
}
