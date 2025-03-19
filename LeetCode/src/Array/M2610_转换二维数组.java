package Array;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/03/19
 * @file M2610_转换二维数组.java
 * <p>
 * 思路
 * 模拟
 * 1. set去重 -- O(n^2)
 * 2. map记录次数 -- O(n^2)
 * 3. 一次遍历 -- O(n)
 */
public class M2610_转换二维数组 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (nums[j] > 0 && st.add(nums[j])) {
                    nums[j] = 0;
                }
            }
            if (!st.isEmpty()) {
                res.add(new ArrayList<>(st));
            }
        }

        return res;
    }

    public List<List<Integer>> findMatrix2(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.merge(num, 1, Integer::sum);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!mp.isEmpty()) {
            List<Integer> li = new ArrayList<>(mp.keySet());
            res.add(li);
            for (int num : li) {
                int c = mp.get(num) - 1;
                if (c == 0) {
                    mp.remove(num);
                } else {
                    mp.put(num, c);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> findMatrix3(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int[] cnt = new int[n + 1];
        for (int num : nums) {
            if (cnt[num] == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(cnt[num]).add(num);
            cnt[num]++;
        }

        return res;
    }
}
