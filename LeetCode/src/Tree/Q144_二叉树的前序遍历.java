package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hyperspace
 * @date 2022/02/18
 */
public class Q144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        preorder(cur, res);

        return res;
    }

    private void preorder(TreeNode cur, List<Integer> res) {
        if (cur != null) {
            res.add(cur.val);
            preorder(cur.left, res);
            preorder(cur.right, res);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.push(cur);
                res.add(cur.val);
                cur = cur.left;
            } else {
                cur = stk.pop();
                cur = cur.right;
            }
        }

        return res;
    }
}
