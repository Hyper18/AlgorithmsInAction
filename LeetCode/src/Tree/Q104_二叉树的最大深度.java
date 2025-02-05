package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2022/03/01
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 */
public class Q104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = dfs(cur.left);
        int right = dfs(cur.right);

        return Math.max(left, right) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            while (curSize > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                curSize--;
            }
            ans++;
        }

        return ans;
    }
}
