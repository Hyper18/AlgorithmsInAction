package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2024/02/07
 * @file M2641_二叉树的堂兄弟节点II.java
 * <p>
 * 思路
 * bfs
 */
public class M2641_二叉树的堂兄弟节点II {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        root.val = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int sum = 0;
            Queue<TreeNode> cur = new ArrayDeque<>();
            for (TreeNode tr : q) {
                if (tr.left != null) {
                    cur.offer(tr.left);
                    sum += tr.left.val;
                }
                if (tr.right != null) {
                    cur.offer(tr.right);
                    sum += tr.right.val;
                }
            }
            for (TreeNode tr : q) {
                int ownChildVal = (tr.left != null ? tr.left.val : 0) + (tr.right != null ? tr.right.val : 0);
                if (tr.left != null) {
                    tr.left.val = sum - ownChildVal;
                }
                if (tr.right != null) {
                    tr.right.val = sum - ownChildVal;
                }
            }
            q = cur;
        }

        return root;
    }
}
