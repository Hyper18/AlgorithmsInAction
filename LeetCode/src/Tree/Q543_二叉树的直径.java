package Tree;

/**
 * @author Hyper
 * @date 2022/03/01
 */
public class Q543_二叉树的直径 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode cur = root;
        DFSTraverse(cur);

        return ans;
    }

    private int DFSTraverse(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = DFSTraverse(cur.left);
        int right = DFSTraverse(cur.right);
        ans = Math.max(ans, left + right);

        return Math.max(left, right) + 1;
    }
}
