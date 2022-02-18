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
        preorder(root, res);

        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            if (root != null) {
                stk.push(root);
                res.add(root.val);
                root = root.left;
            } else {
                root = stk.pop();
                root = root.right;
            }
        }

        return res;
    }
}
