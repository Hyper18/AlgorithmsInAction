package BitOp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hyper
 * @date 2024/10/12
 * @file M3158_求出出现两次数字的XOR值.java
 */
public class M3158_求出出现两次数字的XOR值 {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.merge(num, 1, Integer::sum);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() == 2) {
                ans = ans == 0 ? e.getKey() : ans ^ e.getKey();
            }
        }

        return ans;
    }

    public int duplicateNumbersXOR2(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            if (st.contains(num)) {
                ans ^= num;
            } else {
                st.add(num);
            }
        }

        return ans;
    }

    public int duplicateNumbersXOR3(int[] nums) {
        int ans = 0;
        long vis = 0;
        for (int num : nums) {
            if ((vis >> num & 1) > 0) {
                ans ^= num;
            } else {
                vis |= 1L << num;
            }
        }

        return ans;
    }
}
