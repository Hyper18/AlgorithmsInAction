package Tree;

/**
 * @author Hyper
 * @date 2025/04/25
 * @file M1372_二叉树中的最长交错路径.java
 * <p>
 * 思路
 * dfs
 */
public class M1372_二叉树中的最长交错路径 {
    private int ans;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, false);
        dfs(root, 0, true);
        return ans;
    }

    private void dfs(TreeNode cur, int d, boolean isRight) {
        if (cur == null) {
            ans = Math.max(ans, d - 1);
            return;
        }
        dfs(cur.left, !isRight ? 1 : d + 1, false);
        dfs(cur.right, isRight ? 1 : d + 1, true);
    }
}
