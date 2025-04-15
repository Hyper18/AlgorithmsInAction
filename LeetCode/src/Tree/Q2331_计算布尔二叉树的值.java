package Tree;

/**
 * @author Hyperspace
 * @date 2025/04/15
 * @file Q2331_计算布尔二叉树的值.java
 * <p>
 * 思路
 * dfs
 */
public class Q2331_计算布尔二叉树的值 {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
