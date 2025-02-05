package BackTracking;

import java.util.*;

/**
 * @author Hyper
 * @date 2025/02/05
 * @file M90_子集II.java
 * <p>
 * 思路
 * 回溯
 */
public class M90_子集II {
    private int[] nums;
    private List<Integer> path = new ArrayList<>();
    private Set<List<Integer>> st = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return new ArrayList<>(st);
    }

    private void dfs(int i) {
        if (i == nums.length) {
            st.add(new ArrayList<>(path));
            return;
        }
        dfs(i + 1);
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1);
    }
}
