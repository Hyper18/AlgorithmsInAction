package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2023/10/19
 * @file M1726_同积元组.java
 * <p>
 * 思路
 * 1. brute-force
 * 2. C(2_cnt(a*b)) 找同积数目，作hash优化
 */
public class M1726_同积元组 {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        for (int a : nums) {
            for (int b : nums) {
                if (b == a) {
                    continue;
                }
                for (int c : nums) {
                    if (c == b || c == a) {
                        continue;
                    }
                    for (int d : nums) {
                        if (d == c || d == b || d == a) {
                            continue;
                        }
                        if (a * b == c * d) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public int tupleSameProduct2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = nums[i] * nums[j];
                mp.put(k, mp.getOrDefault(k, 0) + 1);
            }
        }
        int ans = 0;
        for (int v : mp.values()) {
            ans += v * (v - 1) * 4;
        }

        return ans;
    }
}
