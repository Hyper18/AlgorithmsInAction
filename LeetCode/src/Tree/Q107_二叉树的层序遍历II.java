package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2022/04/23
 * 1. DFS
 * 虚假的自底向上（API）
 * 2. BFS
 * 逐层迭代至最深位置，头插法，结果顺次弹栈
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

    private void dfs(TreeNode cur, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(cur.val);
        if (cur.left != null) {
            dfs(cur.left, level + 1);
        }
        if (cur.right != null) {
            dfs(cur.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            // 这里采用头插法将每一层的数据插入
            res.add(0, level);
        }

        return res;
    }
}
