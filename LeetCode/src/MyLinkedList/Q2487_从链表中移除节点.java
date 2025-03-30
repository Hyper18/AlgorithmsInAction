package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/29
 * @file Q2487_从链表中移除节点.java
 * <p>
 * 思路
 * 有点脑筋急转弯
 * 正难则反
 * 反转链表+删除节点
 */
public class Q2487_从链表中移除节点 {
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur.next != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
