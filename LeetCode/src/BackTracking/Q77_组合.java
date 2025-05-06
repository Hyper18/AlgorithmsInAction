package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/05/06
 * @file Q77_组合.java
 * <p>
 * 思路
 * 组合型回溯
 * 1. 枚举选哪个：正序、反序
 * 剪枝不可能达到 k 个的情况
 * 2. 选或不选
 */
public class Q77_组合 {
    class Solution1_0 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int n, k;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1);

            return res;
        }

        private void backtrack(int i) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i, d = k - path.size(); j <= n - d + 1; j++) {
                path.add(j);
                backtrack(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution1_1 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int k;

        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            backtrack(n);

            return res;
        }

        private void backtrack(int i) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i, d = k - path.size(); j >= d; j--) {
                path.add(j);
                backtrack(j - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution2 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int n;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            backtrack(1, k);

            return res;
        }

        private void backtrack(int i, int k) {
            if (i > n - k + 1) {
                return;
            }
            if (k == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            path.add(i);
            backtrack(i + 1, k - 1);
            path.remove(path.size() - 1);
            backtrack(i + 1, k);
        }
    }
}
