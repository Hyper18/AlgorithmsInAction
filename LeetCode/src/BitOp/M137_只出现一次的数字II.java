package BitOp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2023/10/15
 * @file M137_只出现一次的数字II.java
 * <p>
 * 思路
 * 1. hash
 * 2. 位运算
 * 对每个第i个二进制位，
 * 连续累和，再取对3的余数一定为0或1
 */
public class M137_只出现一次的数字II {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = 0;
            for (int num : nums) {
                t += (num >> i) & 1;
            }
            if (t % 3 != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}
