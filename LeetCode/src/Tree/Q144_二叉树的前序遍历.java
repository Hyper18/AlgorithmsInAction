package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/02/18，2024/02/11
 * <p>
 * 思路
 * 1. 递归
 * 2. 迭代
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

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stk.pop();
            cur = cur.right;
        }

        return res;
    }
}
