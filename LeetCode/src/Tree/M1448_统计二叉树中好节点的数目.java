package Tree;

/**
 * @author Hyper
 * @date 2023/08/25
 * @file M1448_统计二叉树中好节点的数目.java
 * <p>
 * 思路
 * dfs
 */
public class M1448_统计二叉树中好节点的数目 {
    int ans;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode tr, int max) {
        if (tr == null) {
            return;
        }
        if (tr.val >= max) {
            ans++;
            max = tr.val;
        }
        dfs(tr.left, max);
        dfs(tr.right, max);
    }
}
