package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/10/13，2025/05/01
 * <p>
 * 思路
 * 1. 中序遍历
 * 2. 空间优化
 */
public class Q230_二叉搜索树中第K小的元素 {
    private List<Integer> res = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res.get(k - 1);
    }

    public void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);
        res.add(cur.val);
        inorder(cur.right);
    }

    private int k, ans;

    public int kthSmallest2(TreeNode root, int k) {
        this.k = k;
        inorder2(root);
        return ans;
    }

    private void inorder2(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder2(cur.left);
        if (--k == 0) {
            ans = cur.val;
            return;
        }
        inorder2(cur.right);
    }
}
