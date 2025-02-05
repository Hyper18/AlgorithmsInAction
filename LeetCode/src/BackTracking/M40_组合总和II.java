package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/01/26
 * @file M40_组合总和II.java
 * <p>
 * 思路
 * 回溯 TLE
 */
public class M40_组合总和II {
    private int[] candidates;
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(target, 0);
        return res;
    }

    public void backtrack(int target, int i) {
        if (target <= 0) {
            if (target == 0) {
                List<Integer> cur = new ArrayList<>(path);
                if (!res.contains(cur))
                    res.add(cur);
            }
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            path.add(candidates[j]);
            backtrack(target - candidates[j], j + 1);
            path.remove(path.size() - 1);
        }
    }
}
