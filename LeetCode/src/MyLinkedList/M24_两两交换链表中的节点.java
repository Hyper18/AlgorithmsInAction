package MyLinkedList;

/**
 * @author Hyper
 * @date 2023/08/06
 * @file M24_两两交换链表中的节点.java
 * <p>
 * 思路
 * 1) 模拟，一次拼接两个结点
 * 注意特判
 * P.S. AC后比官解简洁，hia
 * 2) 递归
 */
public class M24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(), cur = dummy;
        if (head != null && head.next == null) {
            return head;
        }
        while (head != null && head.next != null) {
            cur.next = head.next;
            head.next = head.next.next;
            cur = cur.next;
            cur.next = head;
            head = head.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head.next;
        head.next = swapPairs2(dummy.next);
        dummy.next = head;

        return dummy;
    }
}
