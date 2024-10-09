package BitOp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2023/10/16
 * @file M260_只出现一次的数字III.java
 * <p>
 * 思路
 * 1. hash
 * 2. 位运算
 * 利用异或的性质
 * 先将所有的数异或，得到的两个出现1次的数的异或
 * 再从int的最高位开始找起，依次向下找到第一个不同的二进制位
 * 接着以此位作为依据，该二进制位为1的为一组，为0的为另一组分别异或
 * 最后两组的结果是为出现1次的两数
 */
public class M260_只出现一次的数字III {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                res[i++] = entry.getKey();
            }
        }

        return res;
    }

    public int[] singleNumber2(int[] nums) {
        int t = 0;
        for (int num : nums) {
            t ^= num;
        }
        int k = -1;
        for (int i = 32; i >= 0 && k == -1; i--) {
            if (((t >> i) & 1) == 1) {
                k = i;
            }
        }
        int[] res = new int[2];
        for (int num : nums) {
            if (((num >> k) & 1) == 1) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
