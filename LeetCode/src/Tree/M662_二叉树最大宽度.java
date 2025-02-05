package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2022/08/27
 */
public class M662_二叉树最大宽度 {
    static class Node {
        TreeNode treeNode;
        int pos;

        public Node(TreeNode treeNode, int pos) {
            this.treeNode = treeNode;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(root, 1));
        int res = 1;
        while (!q.isEmpty()) {
            // key step: pre-store the length of current deque
            int len = q.size();
            int idx = -1;
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                TreeNode treeNode = node.treeNode;
                if (treeNode.left != null) {
                    int leftIdx = node.pos * 2;
                    if (idx == -1) {
                        idx = leftIdx;
                    } else {
                        res = Math.max(res, leftIdx - idx + 1);
                    }
                    q.offer(new Node(treeNode.left, leftIdx));
                }
                if (treeNode.right != null) {
                    int rightIdx = node.pos * 2 + 1;
                    if (idx == -1) {
                        idx = rightIdx;
                    } else {
                        res = Math.max(res, rightIdx - idx + 1);
                    }
                    q.offer(new Node(treeNode.right, rightIdx));
                }
            }
        }

        return res;
    }
}
