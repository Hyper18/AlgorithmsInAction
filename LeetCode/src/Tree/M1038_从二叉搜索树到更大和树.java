package Tree;

/**
 * @author Hyper
 * @date 2023/12/04
 * @file M1038_从二叉搜索树到更大和树.java
 * <p>
 * 思路
 * dfs，右中左
 * 本节点右孩子 = 右子树中右子树值的和
 * 本节点左孩子 = 右子树中右子树值的和 + 本节点值 + 左孩子节点值
 * 本节点值 = 右子树中右子树值的和 + 本节点值
 */
public class M1038_从二叉搜索树到更大和树 {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
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
