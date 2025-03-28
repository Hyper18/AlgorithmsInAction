package MyLinkedList;

/**
 * @author Hyperspace
 * @date 2025/03/28
 * @file Q2816_翻倍以链表形式表示的数字.java
 * <p>
 * 思路
 * 模拟
 * 参见Q206+Q2
 * 反转链表+两数之和
 */
public class Q2816_翻倍以链表形式表示的数字 {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        return reverse(selfAddTwo(head));
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    public ListNode selfAddTwo(ListNode l) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;
        while (l != null) {
            int sum = l.val * 2 + carry;
            carry = sum >= 10 ? 1 : 0;
            sum %= 10;
            cur = cur.next = new ListNode(sum);
            l = l.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
