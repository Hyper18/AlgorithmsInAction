package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/07/20
 * @file M2850_将石头分散到网格图的最少移动次数.java
 * <p>
 * 思路
 * 找到为0的位置，依次处理
 * 题干比较有意思，只有3*3的大小，固定
 * 记录多于1和0的点
 * 枚举所有可能的排列
 */
public class M2850_将石头分散到网格图的最少移动次数 {
    public int minimumMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> repPos = new ArrayList<>(), zeroPos = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = grid[i][j];
                if (t > 1) {
                    while (t-- > 1) {
                        repPos.add(new int[]{i, j});
                    }
                } else if (t == 0) {
                    zeroPos.add(new int[]{i, j});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (List<int[]> rep : permutations(repPos)) {
            int tot = 0;
            for (int i = 0; i < rep.size(); i++) {
                int[] r = rep.get(i), z = zeroPos.get(i);
                tot += Math.abs(r[0] - z[0]) + Math.abs(r[1] - z[1]);
            }
            ans = Math.min(ans, tot);
        }

        return ans;
    }

    private List<List<int[]>> permutations(List<int[]> nums) {
        List<List<int[]>> res = new ArrayList<>();
        permute(nums, 0, res);

        return res;
    }

    private void permute(List<int[]> nums, int st, List<List<int[]>> res) {
        if (st == nums.size()) {
            res.add(new ArrayList<>(nums));
        }
        for (int i = st; i < nums.size(); i++) {
            swap(nums, st, i);
            permute(nums, st + 1, res);
            swap(nums, st, i);
        }
    }

    private void swap(List<int[]> nums, int i, int j) {
        int[] t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
}
