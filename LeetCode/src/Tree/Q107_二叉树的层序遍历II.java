package Tree;


import java.util.*;

/**
 * @author Hyper
 * @date 2022/04/23，2025/05/03
 * 1. dfs
 * 2. bfs
 * 逐层迭代至最深位置，头插法，结果顺次弹栈
 * Q102的变种
 */
public class Q107_二叉树的层序遍历II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        Collections.reverse(res);

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

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
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
            res.add(0, li);
        }

        return res;
    }
}
