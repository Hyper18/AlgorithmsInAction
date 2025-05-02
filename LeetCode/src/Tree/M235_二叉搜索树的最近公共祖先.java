package Tree;

/**
 * @author Hyper
 * @date 2024/02/25，2025/05/02
 * @file M235_二叉搜索树的最近公共祖先.java
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 * 对于该二叉搜索树
 * 若当前节点的值比两者都小，说明应该往右子树遍历
 * 若当前节点的值比两者都大，说明应该往左子树遍历
 * 若当前节点值在[p.val, q.val]间，则为其最近公共祖先
 */
public class M235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < root.val && q.val < root.val ? lowestCommonAncestor(root.left, p, q) : p.val > root.val && q.val > root.val ? lowestCommonAncestor(root.right, p, q) : root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (true) {
            if (cur.val < Math.min(p.val, q.val)) {
                cur = cur.right;
            } else if (cur.val > Math.max(p.val, q.val)) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
    }
}
