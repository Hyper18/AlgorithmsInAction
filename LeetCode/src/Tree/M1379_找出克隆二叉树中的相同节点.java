package Tree;

/**
 * @author Hyperspace
 * @date 2024/04/03
 * @file M1379_找出克隆二叉树中的相同节点.java
 * <p>
 * 思路
 * dfs
 */
public class M1379_找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode o, TreeNode c, TreeNode target) {
        if (o == null) {
            return null;
        }
        if (o == target) {
            return c;
        }
        TreeNode res = dfs(o.left, c.left, target);

        return res == null ? dfs(o.right, c.right, target) : res;
    }
}
