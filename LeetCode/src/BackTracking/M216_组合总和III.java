package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/04/21，2025/05/06
 * @file M216_组合总和III.java
 * <p>
 * 思路
 * 组合型回溯
 * 1. 枚举选哪个：正序、反序
 * 剪枝条件：
 * (1) 还能选的数是否足够 k
 * (2) 剩余数字最小、最大和是否足够 n
 * 利用等差数列求和
 * 2. 选或不选
 */
public class M216_组合总和III {
    class Solution1_0 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int k;

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            backtrack(1, n);
            return res;
        }

        private void backtrack(int i, int r) {
            int d = k - path.size();
            if (9 - i + 1 < d || r < 0 || r > (19 - d) * d / 2) {
                return;
            }
            if (d == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j <= 9; j++) {
                path.add(j);
                backtrack(j + 1, r - j);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution1_1 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int k;

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            backtrack(9, n);

            return res;
        }

        private void backtrack(int i, int r) {
            int d = k - path.size();
            if (i < d || r < 0 || r > (i * 2 + d - 1) * d / 2) {
                return;
            }
            if (d == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j >= d; j--) {
                path.add(j);
                backtrack(j - 1, r - j);
                path.remove(path.size() - 1);
            }
        }
    }

    class Solution2 {
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int k;

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            backtrack(1, n);
            return res;
        }

        private void backtrack(int i, int r) {
            int d = k - path.size();
            if (9 - i + 1 < d || r < 0 || r > (19 - d) * d / 2) {
                return;
            }
            if (d == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (i > 9 || i > r) {
                return;
            }
            path.add(i);
            backtrack(i + 1, r - i);
            path.remove(path.size() - 1);
            backtrack(i + 1, r);
        }
    }
}
