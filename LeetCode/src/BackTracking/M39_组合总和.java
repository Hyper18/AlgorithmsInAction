package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2024/04/20
 * @file M39_组合总和.java
 * <p>
 * 思路
 * dfs回溯
 */
public class M39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> li = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] a, int i, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(li));
            return;
        }
        if (i == a.length || remain < 0) {
            return;
        }
        dfs(a, i + 1, remain);
        li.add(a[i]);
        dfs(a, i, remain - a[i]);
        li.remove(li.size() - 1);
    }
}
