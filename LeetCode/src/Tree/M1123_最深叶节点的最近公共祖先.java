package Tree;

/**
 * @author Hyper
 * @date 2023/09/06
 * @file M1123_最深叶节点的最近公共祖先.java
 * <p>
 * 思路
 * dfs
 * 求最深叶子结点的最小公共子树
 */
public class M1123_最深叶节点的最近公共祖先 {
    int maxDepth = -1;
    TreeNode ans;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    int dfs(TreeNode t, int d) {
        if (t == null) {
            maxDepth = Math.max(maxDepth, d);
            return d;
        }
        int l = dfs(t.left, d + 1);
        int r = dfs(t.right, d + 1);
        if (l == maxDepth && l == r) {
            ans = t;
        }

        return l >= r ? l : r;
    }
}
