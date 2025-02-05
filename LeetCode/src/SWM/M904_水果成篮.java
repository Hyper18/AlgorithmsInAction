package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/10/17
 * <p>
 * 思路
 * SWM，当水果种类超过篮子数目则右移
 */
public class M904_水果成篮 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = fruits.length;
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            cnt.put(fruits[r], cnt.getOrDefault(fruits[r], 0) + 1);
            while (cnt.size() > 2) {
                int c = fruits[l];
                cnt.put(c, cnt.get(c) - 1);
                if (cnt.get(c) == 0) {
                    cnt.remove(c);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
