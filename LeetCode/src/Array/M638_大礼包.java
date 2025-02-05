package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2024/11/03
 * @file M638_大礼包.java
 * <p>
 * 思路
 * dfs，记忆化搜索
 * 每次选择单买或大礼包
 */
public class M638_大礼包 {
    private int n;
    private Map<List<Integer>, Integer> cache = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.n = price.size();
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (cache.containsKey(needs)) {
            return cache.get(needs);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += needs.get(i) * price.get(i);
        }
        for (List<Integer> s : special) {
            List<Integer> li = new ArrayList<>(needs);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (li.get(i) < s.get(i)) {
                    flag = true;
                    break;
                }
                li.set(i, li.get(i) - s.get(i));
            }
            if (!flag) {
                ans = Math.min(ans, s.get(n) + dfs(price, special, li));
            }
        }

        cache.put(needs, ans);
        return ans;
    }
}
