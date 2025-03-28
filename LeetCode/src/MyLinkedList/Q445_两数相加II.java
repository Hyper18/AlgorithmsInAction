package MyLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2023/07/03，2025/03/28
 * @file Q445_两数相加II.java
 * <p>
 * 思路
 * 1. 栈
 * 2. 原地模拟
 * 参见Q206+Q2
 * 反转链表+两数之和
 */
public class Q445_两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stk1 = new ArrayDeque<>(), stk2 = new ArrayDeque<>();
        while (l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stk1.isEmpty() || !stk2.isEmpty() || carry != 0) {
            int x = stk1.isEmpty() ? 0 : stk1.pop(), y = stk2.isEmpty() ? 0 : stk2.pop();
            int cur = x + y + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode p = new ListNode(cur);
            p.next = ans;
            ans = p;
        }

        return ans;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return reverse(addTwo(reverse(l1), reverse(l2)));
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

    public ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val, y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum >= 10 ? 1 : 0;
            sum %= 10;
            cur = cur.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
