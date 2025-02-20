package MyLinkedList;

/**
 * @author Hyper
 * @date 2025/02/20
 * @file Q160_相交链表.java
 * <p>
 * 思路
 * 1. 模拟 对齐尾部 -- O(m + n)
 * 2. 双指针 -- O(m + n)
 */
public class Q160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        int diff = lenA - lenB;
        curA = headA;
        curB = headB;
        if (diff >= 0) {
            while (diff > 0) {
                curA = curA.next;
                diff--;
            }
        } else {
            while (diff < 0) {
                curB = curB.next;
                diff++;
            }
        }
        while (curA != null || curB != null) {
            if (curA.equals(curB)) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }
}
