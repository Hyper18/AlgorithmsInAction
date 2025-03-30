package MyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/03/29
 * @file Q138_随机链表的复制.java
 * <p>
 * 思路
 * 1. map记录random关系
 * 2. 交错链表记录random关系 @宫水三叶
 * 新链表节点的 random 指针指向旧链表对应节点的 random 指针的下一个值
 * <p>
 * 待回看
 */
public class Q138_随机链表的复制 {
    public Node copyRandomList(Node head) {
        Node t = head, dummy = new Node(0), cur = dummy;
        Map<Node, Node> mp = new HashMap<>();
        while (t != null) {
            Node p = new Node(t.val);
            mp.put(t, p);
            cur.next = p;
            cur = cur.next;
            t = t.next;
        }
        cur = dummy.next;
        t = head;
        while (t != null) {
            cur.random = mp.get(t.random);
            cur = cur.next;
            t = t.next;
        }

        return dummy.next;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node t = head;
        while (t != null) {
            Node p = new Node(t.val);
            p.next = t.next;
            t.next = p;
            t = p.next;
        }
        t = head;
        while (t != null) {
            if (t.random != null) {
                t.next.random = t.random.next;
            }
            t = t.next.next;
        }
        t = head;
        Node ans = head.next;
        while (t != null) {
            Node nxt = t.next;
            if (nxt != null) {
                t.next = nxt.next;
            }
            t = nxt;
        }

        return ans;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
