package Tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/03/01，2025/05/02
 * <p>
 * 思路
 * 1. bfs
 * 2. dfs
 */
public class Q102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> li = new ArrayList<>();
            while (n-- > 0) {
                TreeNode p = q.poll();
                li.add(p.val);
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
            res.add(li);
        }

        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode cur, int d) {
        if (res.size() == d) {
            res.add(new ArrayList<>());
        }
        res.get(d).add(cur.val);
        if (cur.left != null) {
            dfs(cur.left, d + 1);
        }
        if (cur.right != null) {
            dfs(cur.right, d + 1);
        }
    }
}
