package Tree;

/**
 * @author Hyper
 * @date 2025/04/15
 * @file Q951_翻转等价二叉树.java
 * <p>
 * 思路
 * dfs
 */
public class Q951_翻转等价二叉树 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        return root1.val == root2.val && ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)));
    }
}
