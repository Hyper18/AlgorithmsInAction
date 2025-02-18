package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2025/02/18
 * @file M2080_区间内查询数字的频率.java
 * <p>
 * 思路
 * 模拟+二分
 * 一般区间查询会先考虑前缀和或线段树
 * 但由于本题每次只查询一个整数
 * 可针对不同数，哈希存储每一个数出现的下标位置
 * 此时同一个数出现的所有下标为升序排列
 * 再应用二分求出此时距离查询的区间左、右端点（闭区间）最近的位置
 * 可求出长度为该数在所查询区间内的频率
 */
public class M2080_区间内查询数字的频率 {
    class RangeFreqQuery {
        private Map<Integer, List<Integer>> mp;

        public RangeFreqQuery(int[] arr) {
            mp = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> li = mp.get(value);
            if (li == null || li.get(0) > right || li.get(li.size() - 1) < left) {
                return 0;
            }
            return binarySearchR(li, right) - binarySearchL(li, left) + 1;
        }

        private int binarySearchL(List<Integer> nums, int target) {
            int low = 0, high = nums.size() - 1;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                if (nums.get(mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

        private int binarySearchR(List<Integer> nums, int target) {
            int low = 0, high = nums.size() - 1;
            while (low < high) {
                int mid = low + ((high - low + 1) >> 1);
                if (nums.get(mid) <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            return high;
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
}
