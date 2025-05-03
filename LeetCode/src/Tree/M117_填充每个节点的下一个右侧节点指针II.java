package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/11/03，2025/05/03
 * @file M117_填充每个节点的下一个右侧节点指针II.java
 * <p>
 * 思路
 * 1. bfs -- O(n) 空间复杂度
 * 2. bfs+链表 -- O(1) 空间复杂度
 * Q116的变种
 */
public class M117_填充每个节点的下一个右侧节点指针II {
    public Node connect1_0(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Node tail = null;
            for (int i = 0; i < n; i++) {
                Node p = q.poll();
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
                if (i > 0) {
                    tail.next = p;
                }
                tail = p;
            }
        }

        return root;
    }

    public Node connect1_1(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Node> t = q;
            int n = t.size();
            q = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node p = t.get(i);
                if (i > 0) {
                    t.get(i - 1).next = p;
                }
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
        }

        return root;
    }

    public Node connect2(Node root) {
        Node dummy = new Node(), cur = root;
        while (cur != null) {
            dummy.next = null;
            Node nxt = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    nxt.next = cur.left;
                    nxt = cur.left;
                }
                if (cur.right != null) {
                    nxt.next = cur.right;
                    nxt = cur.right;
                }
                cur = cur.next;
            }
            cur = dummy.next;
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
