package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/07/17
 * @file Q78_子集.java
 * <p>
 * 思路
 * 回溯
 */
public class Q78_子集 {
    private int[] nums;
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // case1: is not selected
        dfs(i + 1);
        // case2: is selected
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1);
    }
}
