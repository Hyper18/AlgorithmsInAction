package MyLinkedList;

/**
 * @author Hyper
 * @date 2023/08/06，2025/03/28
 * @file M24_两两交换链表中的节点.java
 * <p>
 * 思路
 * 1. 递归
 * 2. 模拟
 * (1) 一次拼接两个结点
 * 注意特判
 * P.S. AC后比官解简洁，hia
 * (2) 更利于理解和记忆的写法
 * 先获取一组需要交换的位置 p1, p2
 * 再依次交换
 * 最后移动 p0 至 p3
 */
public class M24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head.next;
        head.next = swapPairs(dummy.next);
        dummy.next = head;

        return dummy;
    }

    public ListNode swapPairs2_0(ListNode head) {
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

    public ListNode swapPairs2_1(ListNode head) {
        ListNode dummy = new ListNode(0, head), p0 = dummy, p1 = head;
        while (p1 != null && p1.next != null) {
            ListNode p2 = p1.next, p3 = p2.next;
            p0.next = p2;
            p2.next = p1;
            p1.next = p3;
            p0 = p1;
            p1 = p3;
        }

        return dummy.next;
    }
}
