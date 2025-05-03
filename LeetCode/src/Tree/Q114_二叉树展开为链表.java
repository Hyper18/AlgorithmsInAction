package Tree;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q114_二叉树展开为链表.java
 * <p>
 * 思路
 * dfs
 * 比较容易想到的一种做法是前序遍历新建链表
 * 但这种做法对于本题是无效的
 * 因此应该修改原始树结构
 * 使用后序遍历
 */
public class Q114_二叉树展开为链表 {
    private TreeNode dummy = new TreeNode(), t = dummy;

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        t.right = new TreeNode(cur.val);
        t = t.right;
        dfs(cur.left);
        dfs(cur.right);
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.left);
        flatten2(root.right);
        TreeNode l = root.left, r = root.right;
        root.left = null;
        root.right = l;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = r;
    }
}
