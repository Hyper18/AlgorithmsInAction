package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/04/15
 * @file Q987_二叉树的垂序遍历.java
 * <p>
 * 思路
 * dfs
 */
public class Q987_二叉树的垂序遍历 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> sequences = new ArrayList<>();
        dfs(root, 0, 0, sequences);
        sequences.sort((a, b) -> a[1] == b[1] ? a[0] == b[0] ? a[2] - b[2] : a[0] - b[0] : a[1] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        int last = 0;
        for (int[] seq : sequences) {
            if (seq[1] != last) {
                res.add(new ArrayList<>());
                last = seq[1];
            }
            res.get(res.size() - 1).add(seq[2]);
        }

        return res;
    }

    private void dfs(TreeNode cur, int row, int col, List<int[]> sequences) {
        if (cur == null) {
            return;
        }
        sequences.add(new int[]{row, col, cur.val});
        dfs(cur.left, row + 1, col - 1, sequences);
        dfs(cur.right, row + 1, col + 1, sequences);
    }
}
