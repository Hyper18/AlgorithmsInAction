package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/05/12
 * @file M1553_吃掉N个橘子的最少天数.java
 * <p>
 * 思路
 * 记忆化搜索
 */
public class M1553_吃掉N个橘子的最少天数 {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        Integer ans = memo.get(n);
        if (ans != null) {
            return ans;
        }
        ans = Math.min(minDays(n / 2) + n % 2, minDays(n / 3) + n % 3) + 1;
        memo.put(n, ans);

        return ans;
    }
}
