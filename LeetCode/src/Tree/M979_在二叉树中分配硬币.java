package Tree;

/**
 * @author Hyperspace
 * @date 2023/07/14
 * @file M979_在二叉树中分配硬币.java
 * <p>
 * 思路
 * dfs
 */
public class M979_在二叉树中分配硬币 {
    int ans;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int l = cur.left == null ? 0 : dfs(cur.left), r = cur.right == null ? 0 : dfs(cur.right);
        ans += Math.abs(l) + Math.abs(r);

        return l + r + cur.val - 1;
    }
}
