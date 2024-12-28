package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/12/27
 * @file M3159_查询数组中元素的出现位置.java
 * <p>
 * 思路
 * 1. hash
 * 2. 优化
 * <p>
 * 3. 考虑推广的情况，如果每组x不同应如何做？
 * 两层计数，hash记录x，li记录下标
 */
public class M3159_查询数组中元素的出现位置 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length, k = queries.length;
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                li.add(i);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queries[i] > li.size() ? -1 : li.get(queries[i] - 1);
        }

        return res;
    }

    public int[] occurrencesOfElement2(int[] nums, int[] queries, int x) {
        int n = nums.length, k = queries.length, idx = 0;
        int[] pos = new int[n], res = new int[k];
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                pos[idx++] = i;
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queries[i] > idx ? -1 : pos[queries[i] - 1];
        }

        return res;
    }

    public int[] occurrencesOfElement3(int[] nums, int[] queries, int x) {
        int n = nums.length, k = queries.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> li = !mp.containsKey(nums[i]) ? new ArrayList<>() : mp.get(nums[i]);
            li.add(i);
            mp.put(nums[i], li);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!mp.containsKey(x)) {
                res[i] = -1;
                continue;
            }
            List<Integer> li = mp.get(x);
            res[i] = queries[i] > li.size() ? -1 : li.get(queries[i] - 1);
        }

        return res;
    }
}
