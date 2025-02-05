package Tree;

import java.util.*;

/**
 * @author Hyper
 * @date 2022/02/18，2024/02/10
 * <p>
 * 思路
 * 1. 递归
 * 2. 迭代
 */
public class Q94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        inorder(cur, res);

        return res;
    }

    public void inorder(TreeNode cur, List<Integer> res) {
        if (cur != null) {
            inorder(cur.left, res);
            res.add(cur.val);
            inorder(cur.right, res);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                cur = stk.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
