package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/03/14
 */
public class Q47_全排列II {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> permutation = new ArrayList<>();
    private boolean[] visited;
    private int[] nums;
    int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        n = nums.length;
        visited = new boolean[n];

        Arrays.sort(nums);
        backtrack(0);

        return res;
    }

    private void backtrack(int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            backtrack(idx + 1);
            visited[i] = false;
            permutation.remove(idx);
        }
    }
}
