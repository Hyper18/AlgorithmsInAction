package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/02/06
 * <p>
 * 思路
 * 回溯
 */
public class Q47_全排列II2 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] vis;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        vis = new boolean[n];
        backtrack(0);

        return res;
    }

    private void backtrack(int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (vis[j] || (j > 0 && nums[j] == nums[j - 1] && !vis[j - 1])) {
                continue;
            }
            path.add(nums[j]);
            vis[j] = true;
            backtrack(i + 1);
            vis[j] = false;
            path.remove(i);
        }
    }
}
