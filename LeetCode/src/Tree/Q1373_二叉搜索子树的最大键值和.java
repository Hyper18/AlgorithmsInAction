package Tree;

/**
 * @author Hyperspace
 * @date 2025/05/01
 * @file Q1373_二叉搜索子树的最大键值和.java
 * <p>
 * 思路
 * 后序遍历二叉树
 * 第一个元素存当前子树的节点和
 * 第二个元素存所有孩子节点的最大值
 * 第三个元素存所有孩子节点的最小值
 */
public class Q1373_二叉搜索子树的最大键值和 {
    private int ans;

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return ans;
    }

    private int[] postorder(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] l = postorder(cur.left), r = postorder(cur.right);
        if (l != null && r != null && l[1] < cur.val && r[2] > cur.val) {
            int val = cur.val + l[0] + r[0];
            ans = Math.max(ans, val);
            return new int[]{val, Math.max(cur.val, r[1]), Math.min(cur.val, l[2])};
        }

        return null;
    }
}
