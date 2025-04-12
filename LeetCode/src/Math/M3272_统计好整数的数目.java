package Math;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/04/12
 * @file M3272_统计好整数的数目.java
 * <p>
 * 思路
 * 求组合数+枚举
 */
public class M3272_统计好整数的数目 {
    public int countGoodIntegers(int n, int k) {
        Set<String> st = new HashSet<>();
        Map<Character, Integer> cnt = new HashMap<>();
        int half = (n + 1) >> 1, ans = 0;
        for (int i = (int) Math.pow(10, half - 1); i < (int) Math.pow(10, half); i++) {
            String pre = String.valueOf(i);
            String suf = new StringBuilder(n % 2 == 0 ? pre : pre.substring(0, pre.length() - 1)).reverse().toString();
            String s = pre + suf;
            if (Long.parseLong(s) % k != 0) {
                continue;
            }
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            if (!st.add(new String(cs))) {
                continue;
            }
            for (char c : s.toCharArray()) {
                cnt.merge(c, 1, Integer::sum);
            }
            long comb = factorial(n) * (n - cnt.getOrDefault('0', 0)) / n;
            for (int val : cnt.values()) {
                comb /= factorial(val);
            }
            ans += comb;
            cnt.clear();
        }

        return ans;
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }
}
