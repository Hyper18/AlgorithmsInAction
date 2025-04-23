package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/04/23
 * @file M1399_统计最大组的数目.java
 * <p>
 * 思路
 * 模拟
 */
public class M1399_统计最大组的数目 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int cnt = 0, t = i;
            while (t > 0) {
                cnt += t % 10;
                t /= 10;
            }
            mp.merge(cnt, 1, Integer::sum);
        }
        int ans = 0, mx = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            int cnt = e.getValue();
            if (cnt == mx) {
                ans++;
            } else if (cnt > mx) {
                ans = 1;
                mx = cnt;
            }
        }

        return ans;
    }
}
