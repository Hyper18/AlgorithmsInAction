package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hyper
 * @date 2024/07/16
 * @file M2956_找到两个数组中的公共元素.java
 * <p>
 * 思路
 * 模拟
 * 实际上不需要记录次数
 */
public class M2956_找到两个数组中的公共元素 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        Map<Integer, Integer> mp1 = new HashMap<>(), mp2 = new HashMap<>();
        for (int n : nums1) {
            mp1.put(n, mp1.getOrDefault(n, 0) + 1);
        }
        for (int m : nums2) {
            mp2.put(m, mp2.getOrDefault(m, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : mp2.entrySet()) {
            if (mp1.containsKey(e.getKey())) {
                res[1] += e.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> e : mp1.entrySet()) {
            if (mp2.containsKey(e.getKey())) {
                res[0] += e.getValue();
            }
        }

        return res;
    }

    public int[] findIntersectionValues2(int[] nums1, int[] nums2) {
        int[] res = new int[2];
        Set<Integer> mp1 = new HashSet<>(), mp2 = new HashSet<>();
        for (int n : nums1) {
            mp1.add(n);
        }
        for (int m : nums2) {
            if (mp1.contains(m)) {
                res[1]++;
            }
            mp2.add(m);
        }
        for (int n : nums1) {
            if (mp2.contains(n)) {
                res[0]++;
            }
        }

        return res;
    }
}
