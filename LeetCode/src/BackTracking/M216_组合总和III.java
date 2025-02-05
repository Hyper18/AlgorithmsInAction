package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/04/21
 * @file M216_组合总和III.java
 * <p>
 * 思路
 * 回溯
 */
public class M216_组合总和III {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> li = new ArrayList<>();
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(1, n);
        return res;
    }

    private void dfs(int i, int r) {
        if (r == 0) {
            if (li.size() == k) {
                res.add(new ArrayList<>(li));
            }
            return;
        }
        if (i > 9 || i > r || li.size() >= k) {
            return;
        }

        li.add(i);
        dfs(i + 1, r - i);
        li.remove(li.size() - 1);
        dfs(i + 1, r);
    }
}
