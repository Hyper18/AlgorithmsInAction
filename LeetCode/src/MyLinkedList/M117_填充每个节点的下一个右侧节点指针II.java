package MyLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2023/11/03
 * @file M117_填充每个节点的下一个右侧节点指针II.java
 * <p>
 * 思路
 * bfs
 */
public class M117_填充每个节点的下一个右侧节点指针II {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Node tail = null;
            for (int i = 1; i <= n; i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (i != 1) {
                    tail.next = cur;
                }
                tail = cur;
            }
        }

        return root;
    }
}
