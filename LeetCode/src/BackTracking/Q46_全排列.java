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
    private int n;
    private List<List<Integer>> res;
    private List<Integer> output;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        backtrack(0);
        return res;
    }

    private void backtrack(int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            backtrack(first + 1);
            // 执行撤销操作
            Collections.swap(output, first, i);
        }
    }
}
