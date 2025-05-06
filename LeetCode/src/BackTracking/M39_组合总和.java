package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/04/20，2025/05/06
 * @file M39_组合总和.java
 * <p>
 * 思路
 * 组合型回溯
 * 1. 选或不选
 * 2. 枚举选哪个
 */
public class M39_组合总和 {
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int[] candidates;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            backtrack(0, target);

            return res;
        }

        private void backtrack(int i, int r) {
            if (i == candidates.length || r <= 0) {
                if (r == 0) {
                    res.add(new ArrayList<>(path));
                }
                return;
            }
            backtrack(i + 1, r);
            path.add(candidates[i]);
            backtrack(i, r - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
