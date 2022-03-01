package Tree;

/**
 * @author Hyperspace
 * @date 2022/03/01
 * <p>
 * 1. 递归写法
 * 2. 优化版本
 */
public class Q226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        return traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftSubTree = traverse(root.left);
        TreeNode rightSubTree = traverse(root.right);

        root.left = rightSubTree;
        root.right = leftSubTree;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree2(root.left);
        invertTree2(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
