package Tree;

/**
 * @author Hyper
 * @date 2025/04/29
 * @file Q700_二叉搜索树中的搜索.java
 * <p>
 * 思路
 * dfs
 */
public class Q700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return searchBST(root.val > val ? root.left : root.right, val);
    }
}
