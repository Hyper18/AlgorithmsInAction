package Tree;

/**
 * @author Hyperspace
 * @date 2023/09/06
 * @file M236_二叉树的最近公共祖先.java
 * <p>
 * 思路
 * dfs，分类讨论：
 * 1) 当前结点为空/p/q -> 返回当前结点
 * 2) 左子树找到，且右子树找到 -> 返回递当前结点
 * 3) 左子树找到，右子树未找到 -> 返回递归左子树的结果
 * 4) 左子树未找到，右子树找到 -> 返回递归右子树的结果
 * 5) 左子树未找到，且右子树未找到 -> 返回null
 */
public class M236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }
}
