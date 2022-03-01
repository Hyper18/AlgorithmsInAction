package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/01
 * <p>
 * 思路
 * 1. bfs
 * 2. dfs
 */
public class Q102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);

        }

        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        DFSTraverse(cur, 0);

        return res;
    }

    private void DFSTraverse(TreeNode cur, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(cur.val);
        if (cur.left != null) {
            DFSTraverse(cur.left, level + 1);
        }
        if (cur.right != null) {
            DFSTraverse(cur.right, level + 1);
        }
    }
}
