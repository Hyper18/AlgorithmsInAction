package Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/04/20
 * @file M781_森林中的兔子.java
 * <p>
 * 思路
 * 贪心
 */
public class M781_森林中的兔子 {
    private final int N = 1010;
    private int[] counts = new int[N];

    public int numRabbits(int[] answers) {
        int ans = 0;
        for (int i : answers) {
            if (counts[i] > 0) {
                counts[i]--;
            } else {
                counts[i] = i;
                ans += i + 1;
            }
        }

        return ans;
    }

    public int numRabbits2(int[] answers) {
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : answers) {
            mp.merge(x, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            int k = e.getKey() + 1, v = e.getValue();
            ans += (v + k - 1) / k * k;
        }

        return ans;
    }
}
