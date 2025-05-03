package Tree;

/**
 * @author Hyper
 * @date 2025/04/15，2025/05/03
 * <p>
 * 思路
 * dfs
 */
public class Q226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = invertTree(root.left), r = invertTree(root.right);
        root.left = r;
        root.right = l;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree2(root.left);
        invertTree2(root.right);

        return root;
    }
}
