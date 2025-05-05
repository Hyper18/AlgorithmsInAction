package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/07/17，2025/05/04
 * @file Q78_子集.java
 * <p>
 * 思路
 * 回溯
 */
public class Q78_子集 {
    class Solution1_0 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int[] nums;

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            backtrack(0);

            return res;
        }

        private void backtrack(int i) {
            if (i == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            backtrack(i + 1);
            path.add(nums[i]);
            backtrack(i + 1);
            path.remove(path.size() - 1);
        }
    }

    class Solution1_1 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int[] nums;

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            backtrack(0);

            return res;
        }

        private void backtrack(int i) {
            res.add(new ArrayList<>(path));
            for (int j = i; j < nums.length; j++) {
                path.add(nums[j]);
                backtrack(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
