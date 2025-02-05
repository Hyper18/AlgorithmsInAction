package Tree;

/**
 * @author Hyper
 * @date 2023/12/04
 * @file Q538_把二叉搜索树转换为累加树.java
 */
public class Q538_把二叉搜索树转换为累加树 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        dfs(cur);

        return root;
    }

    private void dfs(TreeNode cur) {
        if (cur != null) {
            dfs(cur.right);
            sum += cur.val;
            cur.val = sum;
            dfs(cur.left);
        }
    }
}
