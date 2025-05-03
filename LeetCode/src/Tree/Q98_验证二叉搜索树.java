package Tree;

/**
 * @author Hyperspace
 * @date 2025/04/25，2025/05/03
 * @file Q98_验证二叉搜索树.java
 * <p>
 * 思路
 * dfs
 * 1. 前序遍历
 * 这种写法逻辑上最顺
 * 2. 中序遍历
 * 3. 后序遍历
 * <p>
 * 注意取值范围不要爆int
 */
public class Q98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode cur, long l, long r) {
        if (cur == null) {
            return true;
        }
        return l < cur.val && cur.val < r && dfs(cur.left, l, cur.val) && dfs(cur.right, cur.val, r);
    }

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left) || root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST2(root.right);
    }

    private long INF = Long.MAX_VALUE;

    public boolean isValidBST3(TreeNode root) {
        return dfs(root)[1] != INF;
    }

    private long[] dfs(TreeNode cur) {
        if (cur == null) {
            return new long[]{INF, -INF};
        }
        long[] l = dfs(cur.left);
        if (cur.val <= l[1]) {
            return new long[]{-INF, INF};
        }
        long[] r = dfs(cur.right);
        if (cur.val >= r[0]) {
            return new long[]{-INF, INF};
        }

        return new long[]{Math.min(l[0], cur.val), Math.max(r[1], cur.val)};
    }
}
