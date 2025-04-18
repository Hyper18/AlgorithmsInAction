package Tree;

/**
 * @author Hyper
 * @date 2024/04/05，2025/04/18
 * @file M1026_节点与其祖先之间的最大差值.java
 * <p>
 * 思路
 * 1. 向下dfs
 * 2. 向上dfs
 */
public class M1026_节点与其祖先之间的最大差值 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode cur, int mn, int mx) {
        if (cur == null) {
            return mx - mn;
        }
        mn = Math.min(mn, cur.val);
        mx = Math.max(mx, cur.val);

        return Math.max(dfs(cur.left, mn, mx), dfs(cur.right, mn, mx));
    }

    private int ans;

    public int maxAncestorDiff2(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] l = dfs(cur.left), r = dfs(cur.right);
        int mn = Math.min(cur.val, Math.min(l[0], r[0])), mx = Math.max(cur.val, Math.max(l[1], r[1]));
        ans = Math.max(ans, Math.max(cur.val - mn, mx - cur.val));

        return new int[]{mn, mx};
    }
}
