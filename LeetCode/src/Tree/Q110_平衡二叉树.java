package Tree;

/**
 * @author Hyper
 * @date 2022/04/22，2025/04/15
 * <p>
 * 思路
 * dfs
 * 从根节点开始
 * 按 左子树 -> 右子树顺序依次判断子树高度
 * 若左子树与右子树高度差大于1，则不符合条件
 */
public class Q110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode cur) {
        return cur == null ? 0 : Math.max(dfs(cur.left), dfs(cur.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return dfs2(root) != -1;
    }

    private int dfs2(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int l = dfs2(cur.left), r = dfs2(cur.right);
        if (l == -1 || r == -1) {
            return -1;
        }

        return Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
    }
}
