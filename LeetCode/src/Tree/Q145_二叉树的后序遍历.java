package Tree;

import java.util.*;

/**
 * @author Hyper
 * @date 2022/02/18，2024/02/12
 * <p>
 * 思路
 * 1. 递归
 * 2. 迭代
 */
public class Q145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        postorder(cur, res);

        return res;
    }

    private void postorder(TreeNode cur, List<Integer> res) {
        if (cur != null) {
            postorder(cur.left, res);
            postorder(cur.right, res);
            res.add(cur.val);
        }
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                cur = stk.peek();
                if (cur.right != null && cur.right != pre) {
                    cur = cur.right;
                } else {
                    cur = stk.pop();
                    res.add(cur.val);
                    pre = cur;
                    cur = null;
                }
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                cur = stk.pop();
                res.add(cur.val);
                pre = cur;
                cur = null;
            }
        }

        return res;
    }
}
