package Tree;

/**
 * @author Hyperspace
 * @date 2022/04/22
 * 思路
 * 先走左子树
 * 若两子树均为空，则返回
 */
public class Q111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(ans, minDepth(root.left));
        }
        if (root.right != null) {
            ans = Math.min(ans, minDepth(root.right));
        }

        return ans + 1;
    }
}
