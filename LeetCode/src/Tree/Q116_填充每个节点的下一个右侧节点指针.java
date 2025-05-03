package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2025/05/03
 * @file Q116_填充每个节点的下一个右侧节点指针.java
 * <p>
 * 思路
 * 1. bfs -- O(n) 空间复杂度
 * 在层序遍历的同时为同一层的节点添加指针
 * 2. bfs+链表 -- O(1) 空间复杂度
 * <p>
 * 注意本题的二叉树可为空
 */
public class Q116_填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                Node p = q.poll();
                if (n > 0) {
                    p.next = q.peek();
                }
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
        }

        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        while (cur.left != null) {
            Node p = cur;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            cur = cur.left;
        }

        return root;
    }

    // Definition for a Node.
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
