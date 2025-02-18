package Design;

import java.util.*;

/**
 * @author Hyper
 * @date 2025/02/18
 * @file M2080_区间内查询数字的频率.java
 * <p>
 * 思路
 * 模拟+二分
 * 可进一步用api简化
 */
public class M2080_区间内查询数字的频率2 {
    class RangeFreqQuery {
        private Map<Integer, List<Integer>> mp;

        public RangeFreqQuery(int[] arr) {
            mp = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (!mp.containsKey(value)) {
                return 0;
            }
            List<Integer> li = mp.get(value);
            int l = Collections.binarySearch(li, left);
            l = l < 0 ? -l - 1 : l;
            int r = Collections.binarySearch(li, right + 1);
            r = r < 0 ? -r - 1 : r;

            return r - l;
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
}
