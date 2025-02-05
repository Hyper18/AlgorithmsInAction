package Tree;

/**
 * @author Hyper
 * @date 2022/04/22
 * 递归
 * 从根节点开始
 * 按 左子树 -> 右子树顺序依次判断子树高度
 * 若左子树与右子树高度差大于1，则不符合条件
 */
public class Q110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(f(root.left) - f(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int f(TreeNode node) {
        return node == null ? 0 : Math.max(f(node.left), f(node.right)) + 1;
    }
}
