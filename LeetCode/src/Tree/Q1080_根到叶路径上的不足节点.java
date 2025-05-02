package Tree;

/**
 * @author Hyperspace
 * @date 2025/05/02
 * @file Q1080_根到叶路径上的不足节点.java
 * <p>
 * 思路
 * dfs
 */
public class Q1080_根到叶路径上的不足节点 {
    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        return dfs(root, 0);
    }

    private TreeNode dfs(TreeNode cur, int sum) {
        if (cur == null) {
            return null;
        }
        sum += cur.val;
        if (cur.left == null && cur.right == null) {
            return sum < limit ? null : cur;
        }
        cur.left = dfs(cur.left, sum);
        cur.right = dfs(cur.right, sum);

        return cur.left == null && cur.right == null ? null : cur;
    }
}
