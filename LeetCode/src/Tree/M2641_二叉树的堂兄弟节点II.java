package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/02/07，2025/05/03
 * @file M2641_二叉树的堂兄弟节点II.java
 * <p>
 * 思路
 * bfs
 * <p>
 * 注意root的值处理
 */
public class M2641_二叉树的堂兄弟节点II {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> t = new ArrayList<>();
            int sum = 0;
            for (TreeNode p : q) {
                if (p.left != null) {
                    t.add(p.left);
                    sum += p.left.val;
                }
                if (p.right != null) {
                    t.add(p.right);
                    sum += p.right.val;
                }
            }
            for (TreeNode p : q) {
                int ownChildVal = (p.left != null ? p.left.val : 0) + (p.right != null ? p.right.val : 0);
                if (p.left != null) {
                    p.left.val = sum - ownChildVal;
                }
                if (p.right != null) {
                    p.right.val = sum - ownChildVal;
                }
            }
            q = t;
        }

        return root;
    }
}
