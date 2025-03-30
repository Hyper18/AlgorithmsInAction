package MyLinkedList;

/**
 * @author Hyper
 * @date 2022/02/20，2025/03/29
 * <p>
 * 思路
 * 1. 迭代
 * 2. 递归
 */
public class Q203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
