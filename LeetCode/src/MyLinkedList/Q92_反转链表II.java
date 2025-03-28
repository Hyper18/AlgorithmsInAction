package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/28
 * @file Q92_反转链表II.java
 * <p>
 * 思路
 * 模拟 -- O(n)
 * 原地反转
 * Q206的变体
 * 多了考虑区间反转的步骤
 */
public class Q92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        ListNode pre = null, cur = p.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p.next.next = cur;
        p.next = pre;

        return dummy.next;
    }
}
