package Tree;

import java.util.*;

/**
 * @author Hyper
 * @date 2022/02/18，2024/02/10，2025/05/03
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 * 本质和dfs是相同的，需要显式地维护一个栈
 */
public class Q94_二叉树的中序遍历 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);
        res.add(cur.val);
        inorder(cur.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
