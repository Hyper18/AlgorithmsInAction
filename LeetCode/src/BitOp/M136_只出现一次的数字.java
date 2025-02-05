package BitOp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2023/10/14
 * @file M136_只出现一次的数字.java
 * <p>
 * 思路
 * 1. hash
 * 时间复杂度上满足O(n)线性，只进行1次遍历操作
 * 空间复杂度上仍不满足常数空间的要求
 * 2. 位运算
 * a 异或 a = 0
 */
public class M136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                set.remove(n);
            }
        }

        return set.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }

        return ans;
    }
}
