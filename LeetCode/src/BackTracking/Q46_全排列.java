package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/03/08，2025/06/16
 * <p>
 * 思路
 * 排列型回溯 -- O(n×n!)
 * 枚举选哪个
 * <p>
 * 注：对排列型回溯，选或不选的思路不适用
 */
public class Q46_全排列 {
    class Solution1_0 {
        private List<List<Integer>> res;
        private List<Integer> permutation;
        private int n;

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

    class Solution1_1 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private boolean[] vis;
        private int[] nums;
        private int n;

        public List<List<Integer>> permute(int[] nums) {
            n = nums.length;
            this.nums = nums;
            vis = new boolean[n];
            for (int num : nums) {
                path.add(num);
            }
            backtrack(0);

            return res;
        }

        private void backtrack(int i) {
            if (i == n) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    continue;
                }
                path.set(i, nums[j]);
                vis[j] = true;
                backtrack(i + 1);
                vis[j] = false;
            }
        }
    }
}
