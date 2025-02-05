package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2023/11/04
 * @file M421_数组中两个数的最大异或值.java
 * <p>
 * 思路
 * 看数据范围，暴力O(n2) --> TLE
 * 对结果从高位开始枚举
 */
public class M421_数组中两个数的最大异或值 {
    final int INT_SIZE = 32;

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int high = INT_SIZE - 1 - Integer.numberOfLeadingZeros(max);
        int ans = 0, mask = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = high; i >= 0; i--) {
            set.clear();
            mask |= 1 << i;
            int newAns = ans | (1 << i);
            for (int x : nums) {
                x &= mask;
                if (set.contains(newAns ^ x)) {
                    ans = newAns;
                    break;
                }
                set.add(x);
            }
        }

        return ans;
    }
}
