package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q113_路径总和II.java
 * <p>
 * 思路
 */
public class Q113_路径总和II {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode cur, int target, List<Integer> path) {
        if (cur == null) {
            return;
        }
        target -= cur.val;
        path.add(cur.val);
        if (cur.left == null && cur.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(cur.left, target, path);
        dfs(cur.right, target, path);
        path.remove(path.size() - 1);
    }
}
