package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/02/18
 * <p>
 * 思路
 * 1. 递归
 * 2. 迭代
 */
public class Q94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while (root != null || !stk.isEmpty()) {
            if (root != null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }
}
