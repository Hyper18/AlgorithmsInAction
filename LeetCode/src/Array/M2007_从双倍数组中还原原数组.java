package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/04/18
 * @file M2007_从双倍数组中还原原数组.java
 * <p>
 * 思路
 * 模拟
 * 1. 排序，哈希
 * 2. 无需先计数，merge()的使用
 */
public class M2007_从双倍数组中还原原数组 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed);
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : changed) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[n >> 1];
        int i = 0;
        for (int num : changed) {
            if (cnts.get(num) == 0) {
                continue;
            }
            cnts.put(num, cnts.get(num) - 1);
            if (cnts.getOrDefault(num << 1, 0) == 0) {
                return new int[0];
            }
            cnts.put(num << 1, cnts.get(num << 1) - 1);
            res[i++] = num;
        }

        return res;
    }

    public int[] findOriginalArray2(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed);
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] res = new int[n >> 1];
        int i = 0;
        for (int num : changed) {
            if (!cnt.containsKey(num)) {
                if (i == res.length) {
                    return new int[0];
                }
                res[i++] = num;
                cnt.merge(num << 1, 1, Integer::sum);
            } else {
                int c = cnt.merge(num, -1, Integer::sum);
                if (c == 0) {
                    cnt.remove(num);
                }
            }
        }

        return res;
    }
}
