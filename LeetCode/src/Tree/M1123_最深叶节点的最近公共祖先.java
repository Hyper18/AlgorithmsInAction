package Tree;

/**
 * @author Hyper
 * @date 2023/09/06，2025/05/02
 * @file M1123_最深叶节点的最近公共祖先.java
 * <p>
 * 思路
 * dfs
 * 求最深叶子节点的最小公共子树
 */
public class M1123_最深叶节点的最近公共祖先 {
    private TreeNode ans;
    private int mx;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode cur, int d) {
        if (cur == null) {
            mx = Math.max(mx, d);
            return d;
        }
        int l = dfs(cur.left, d + 1), r = dfs(cur.right, d + 1);
        if (mx == l && l == r) {
            ans = cur;
        }

        return Math.max(l, r);
    }
}
