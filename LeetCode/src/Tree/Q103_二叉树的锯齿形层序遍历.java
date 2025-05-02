package Tree;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/05/02
 * @file Q103_二叉树的锯齿形层序遍历.java
 * <p>
 * 思路
 * bfs
 * Q102的变体
 * 考虑对每层的答案间隔倒序，比处理隔层倒序二叉树容易
 */
public class Q103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (res.size() % 2 == 1) {
                Collections.reverse(li);
            }
            res.add(li);
        }

        return res;
    }
}
