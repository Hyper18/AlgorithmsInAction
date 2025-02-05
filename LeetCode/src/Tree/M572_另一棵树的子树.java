package Tree;

/**
 * @author Hyper
 * @date 2024/08/04
 * @file M572_另一棵树的子树.java
 * <p>
 * 思路
 * dfs
 */
public class M572_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dfs(TreeNode r, TreeNode s) {
        if (r == null || s == null) {
            return r == s;
        }
        return r.val == s.val && dfs(r.left, s.left) && dfs(r.right, s.right);
    }
}
