package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/02/05
 * @file M90_子集II.java
 * <p>
 * 思路
 * 回溯
 */
public class M90_子集II2 {
    private int[] nums;
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        int n = nums.length;
        if (i == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        int x = nums[i];
        path.add(x);
        dfs(i + 1);
        path.remove(path.size() - 1);
        i++;
        while (i < n && nums[i] == x) {
            i++;
        }
        dfs(i);
    }
}
