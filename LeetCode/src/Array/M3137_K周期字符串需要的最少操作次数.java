package Array;

import java.util.HashMap;

/**
 * @author Hyperspace
 * @date 2024/08/17
 * @file M3137_K周期字符串需要的最少操作次数.java
 * <p>
 * 思路
 * 模拟
 */
public class M3137_K周期字符串需要的最少操作次数 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length(), ans = Integer.MAX_VALUE;
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String s = word.substring(i, i + k);
            mp.put(s, mp.getOrDefault(s, 0) + 1);
            ans = Math.min(ans, n / k - mp.get(s));
        }

        return ans;
    }

    public int minimumOperationsToMakeKPeriodic2(String word, int k) {
        int n = word.length(), ans = Integer.MAX_VALUE;
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            ans = Math.min(ans, n / k - mp.merge(word.substring(i, i + k), 1, Integer::sum));
        }

        return ans;
    }
}
