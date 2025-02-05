package Tree;

/**
 * @author Hyper
 * @date 2024/04/05
 * @file M1026_节点与其祖先之间的最大差值.java
 * <p>
 * 思路
 * 递归
 */
public class M1026_节点与其祖先之间的最大差值 {
    private int dfs(TreeNode cur, int minVal, int maxVal) {
        if (cur == null) {
            return maxVal - minVal;
        }
        minVal = Math.min(minVal, cur.val);
        maxVal = Math.max(maxVal, cur.val);

        return Math.max(dfs(cur.left, minVal, maxVal), dfs(cur.right, minVal, maxVal));
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}
