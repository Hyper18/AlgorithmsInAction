package Tree;

/**
 * @author Hyper
 * @date 2022/03/01，2025/05/03
 * <p>
 * 思路
 * dfs
 * <p>
 * 注意这里的最长路径不一定要经过root
 */
public class Q543_二叉树的直径 {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int l = dfs(cur.left), r = dfs(cur.right);
        ans = Math.max(ans, l + r);

        return Math.max(l, r) + 1;
    }
}
