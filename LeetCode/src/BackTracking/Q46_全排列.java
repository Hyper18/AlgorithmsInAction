package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * 回溯算法 -- O(n×n!)
 * 参考官解
 */
public class Q46_全排列 {
    private List<List<Integer>> res;
    private List<Integer> permutation;
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        permutation = new ArrayList<>();
        for (int num : nums) {
            permutation.add(num);
        }

        backtrack(0);
        return res;
    }

    private void backtrack(int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(permutation));
        }
        for (int i = idx; i < n; i++) {
            // 动态维护数组
            Collections.swap(permutation, idx, i);
            backtrack(idx + 1);
            // 执行撤销操作，回溯
            Collections.swap(permutation, idx, i);
        }
    }
}
